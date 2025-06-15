package tests.api;

import models.CreateRequest;
import models.UpdateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static models.ApiSpecs.*;
import static tests.api.TestData.*;

@Tag("API")
@Tag("ALL")
public class ProjectTests extends TestBase {

    @Test
    @DisplayName("Get all user's projects")
    void getAllProjectsTest() {
        step("Get list of all user's projects", () -> {
            given()
                    .spec(getRequest)
                    .when()
                    .get("/projects")
                    .then()
                    .spec(response200);
        });
    }

    @Test
    @DisplayName("Get one particular user's project")
    void getSingleProjectTest() {
        final CreateRequest[] projectData = new CreateRequest[1];

        step("Get user's project", () -> {
            projectData[0] = given()
                    .spec(getRequest)
                    .when()
                    .get("/projects/" + projectNumber)
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequest.class);
        });

        step("Check project id in response", () ->
                assertEquals(projectNumber, projectData[0].getId()));
    }

    @Test
    @DisplayName("Add project")
    void addNewProjectTest() {
        CreateRequest createCredentials = new CreateRequest();
        final CreateRequest[] projectData = new CreateRequest[1];
        createCredentials.setName(projectName);

        step("Create project", () -> {
            projectData[0] = given()
                    .spec(creationRequest)
                    .body(createCredentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequest.class);
        });

        step("Check project name in response", () ->
                assertEquals(projectName, projectData[0].getName()));
    }

    @Test
    @DisplayName("Update project name")
    void updateProjectTest() {
        UpdateRequest oldCredentials = new UpdateRequest();
        UpdateRequest newCredentials = new UpdateRequest();
        final CreateRequest[] projectData = new CreateRequest[1];
        final long[] id = new long[1];

        oldCredentials.setName(outdatedTaskName);
        newCredentials.setName(updatedTaskName);

        step("Create project and save its id", () -> {
            id[0] = given()
                    .spec(creationRequest)
                    .body(oldCredentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response200)
                    .body("name", is(outdatedTaskName))
                    .extract().jsonPath().getLong("id");

            newCredentials.setId(id[0]);
        });

        step("Change project's name", () -> {
            given()
                    .spec(creationRequest)
                    .body(newCredentials)
                    .when()
                    .post("/projects/" + id[0])
                    .then()
                    .spec(response200);
        });

        step("Get updated project data", () -> {
            projectData[0] = given()
                    .spec(getRequest)
                    .when()
                    .get("/projects/" + id[0])
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequest.class);
        });

        step("Check project name", () -> {
            assertNotEquals(outdatedTaskName, projectData[0].getName());
            assertEquals(updatedTaskName, projectData[0].getName());
        });
    }

    @Test
    @DisplayName("Delete project")
    void deleteProjectTest() {
        UpdateRequest credentials = new UpdateRequest();
        final long[] id = new long[1];
        credentials.setName(removedProjectName);

        step("Create project and save its id", () -> {
            id[0] = given()
                    .spec(creationRequest)
                    .body(credentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response200)
                    .extract().jsonPath().getLong("id");
        });

        step("Delete project", () -> {
            given()
                    .spec(creationRequest)
                    .when()
                    .delete("/projects/" + id[0])
                    .then()
                    .spec(response204);
        });

        step("Check that project was deleted", () -> {
            given()
                    .spec(getRequest)
                    .when()
                    .get("/projects")
                    .then()
                    .spec(response200)
                    .body("findAll{it.name =~/.*/}.name.flatten()", not(hasItem(removedProjectName)));
        });
    }

    @Test
    @DisplayName("Negative: Create project without name")
    void createProjectWithoutNameTest() {
        CreateRequest createCredentials = new CreateRequest();
        createCredentials.setName("");

        step("Try to create project with empty name", () -> {
            given()
                    .spec(creationRequest)
                    .body(createCredentials)
                    .when()
                    .post("/projects")
                    .then()
                    .spec(response400or422);
        });
    }
}
