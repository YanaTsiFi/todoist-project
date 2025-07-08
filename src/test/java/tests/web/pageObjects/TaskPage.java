package tests.web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TaskPage {
    private final SelenideElement quickAddButton = $x("//button[contains(.,'Добавить')]");
    private final SelenideElement taskInput = $("div[contenteditable='true']");
    private final SelenideElement submitButton = $x("//button[contains(.,'Добавить задачу')]");
    private final SelenideElement taskInList = $(".task_list_item");

    @Step("Create task: {taskName}")
    public void createTask(String taskName) {
        executeJavaScript("arguments[0].click();", quickAddButton);
        taskInput.shouldBe(visible).setValue(taskName);
        executeJavaScript("arguments[0].click();", submitButton);
    }

    @Step("Verify task creation")
    public void verifyTaskCreated() {
        taskInList.shouldBe(visible);
    }
}