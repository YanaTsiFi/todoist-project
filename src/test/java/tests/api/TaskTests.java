package tests.api;

import models.CreateRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static models.ApiSpecs.*;
import static tests.api.TestData.*;

@Tag("API")
@Tag("ALL")
public class TaskTests extends TestBase {

    @Test
    @DisplayName("Add task")
    void addNewTaskTest() {
        CreateRequest createCredentials = new CreateRequest();
        final CreateRequest[] taskData = new CreateRequest[1];
        createCredentials.setContent(taskName);
        createCredentials.setProjectId(projectNumber);
        createCredentials.setDueString("tomorrow at 12:00");

        step("Create task", () -> {
            taskData[0] = given()
                    .spec(creationRequest)
                    .body(createCredentials)
                    .when()
                    .post("/tasks")
                    .then()
                    .spec(response200)
                    .extract().as(CreateRequest.class);
        });

        step("Check task name", () ->
                assertEquals(taskName, taskData[0].getContent()));
    }
}

