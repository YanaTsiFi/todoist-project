package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.web.pageObjects.LoginPage;
import tests.web.pageObjects.TaskPage;

@Tag("WEB")
@Tag("ALL")
@Epic("Todoist UI Tests")
@Feature("Task Creation")
public class TaskTests extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final TaskPage taskPage = new TaskPage();
    private final String TASK_NAME = "TestTask_" + System.currentTimeMillis();

    @Test
    @DisplayName("Create task and verify")
    @Story("Basic task creation")
    @Severity(SeverityLevel.BLOCKER)
    void shouldCreateTask() {
        loginPage.openLoginPage()
                .doLogin(WEB_CONFIG.login(), WEB_CONFIG.password())
                .checkCurrentUrl();
        taskPage.createTask(TASK_NAME);
        taskPage.verifyTaskCreated();
    }
}