package tests.mobile.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement emailInput = $(AppiumBy.xpath(
            "//*[contains(@text, 'Email') or @resource-id='com.todoist:id/email_exists_input']"
    ));

    private final SelenideElement emailEntryButton = $(AppiumBy.xpath(
            "//*[contains(@text, 'Continue with Email')]"
    ));

    @Step("Open login page via Email")
    public LoginPage openLoginPage() {
        emailEntryButton
                .shouldBe(visible, Duration.ofSeconds(15))
                .click();
        return this;
    }

    @Step("Verify Email input field is visible")
    public void checkEmailInputVisible() {
        emailInput.shouldBe(visible, Duration.ofSeconds(10));
    }
}