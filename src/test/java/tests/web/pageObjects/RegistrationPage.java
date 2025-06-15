package tests.web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class RegistrationPage {
    protected final SelenideElement
            startForFreeButton = $("a._button_alspx_1._primary_alspx_188"),
            emailInput = $("#element-0"),
            passwordInput = $("#element-2"),
            submitButton = $("button[type='submit']");

    @Step("Open registration page")
    public RegistrationPage openRegistrationPage() {
        open("/");
        startForFreeButton.click();
        return this;
    }

    @Step("Set email: {email}")
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);
        return this;
    }

    @Step("Set password")
    public RegistrationPage setPassword(String password) {
        passwordInput.setValue(password);
        return this;
    }

    @Step("Submit registration")
    public RegistrationPage submitRegistration() {
        submitButton.click();
        return this;
    }

    @Step("Verify successful registration")
    public RegistrationPage verifySuccessfulRegistration() {
        webdriver().shouldHave(urlContaining("/app"));
        return this;
    }

    @Step("Verify form elements visibility")
    public RegistrationPage verifyFormElementsVisible() {
        emailInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        submitButton.shouldBe(visible, enabled);
        return this;
    }

    @Step("Set email and verify: {email}")
    public RegistrationPage setEmailAndVerify(String email) {
        emailInput
                .shouldBe(visible, interactable)
                .setValue(email)
                .shouldHave(value(email));
        return this;
    }

    @Step("Set password and verify")
    public RegistrationPage setPasswordAndVerify(String password) {
        passwordInput
                .shouldBe(visible, interactable)
                .setValue(password)
                .shouldHave(value(password));
        return this;
    }

    @Step("Verify 'Start for free' button visibility")
    public RegistrationPage verifyStartForFreeButtonVisible() {
        startForFreeButton.shouldBe(visible, enabled);
        return this;
    }
}
