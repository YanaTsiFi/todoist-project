package tests.web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class RegistrationPage {
    protected final SelenideElement startForFreeButton =
            $$("div.hero_details__quLR0 a").findBy(text("Start for free")),
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
    public void verifySuccessfulRegistration() {
        webdriver().shouldHave(urlContaining("/app"));
    }

    @Step("Verify form elements visibility")
    public void verifyFormElementsVisible() {
        emailInput.shouldBe(visible);
        passwordInput.shouldBe(visible);
        submitButton.shouldBe(visible, enabled);
    }

    @Step("Set email and verify: {email}")
    public void setEmailAndVerify(String email) {
        emailInput
                .shouldBe(visible, interactable)
                .setValue(email)
                .shouldHave(value(email));
    }

    @Step("Set password and verify")
    public void setPasswordAndVerify(String password) {
        passwordInput
                .shouldBe(visible, interactable)
                .setValue(password)
                .shouldHave(value(password));
    }

    @Step("Verify 'Start for free' button visibility")
    public void verifyStartForFreeButtonVisible() {
        startForFreeButton.shouldBe(visible, enabled);
    }
}