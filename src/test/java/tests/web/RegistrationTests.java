package tests.web;

import helpers.DataGenerator;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.web.pageObjects.RegistrationPage;

import static com.codeborne.selenide.Selenide.open;

@Tag("WEB")
@Tag("REGISTRATION")
@Epic("User Registration")
@Feature("Signup Functionality")
public class RegistrationTests extends TestBase {
    private final RegistrationPage registrationPage = new RegistrationPage();
    private final DataGenerator dataGenerator = new DataGenerator();

    @Test
    @DisplayName("Registration form elements visibility")
    @Story("UI Elements Verification")
    @Severity(SeverityLevel.CRITICAL)
    void registrationFormElementsTest() {
        registrationPage.openRegistrationPage()
                .verifyFormElementsVisible();
    }

    @Test
    @DisplayName("Email input field accepts text")
    @Story("Field Validation")
    @Severity(SeverityLevel.NORMAL)
    void emailInputAcceptsTextTest() {
        registrationPage.openRegistrationPage()
                .setEmailAndVerify("test@example.com");
    }

    @Test
    @DisplayName("Password input field accepts text")
    @Story("Field Validation")
    @Severity(SeverityLevel.NORMAL)
    void passwordInputAcceptsTextTest() {
        registrationPage.openRegistrationPage()
                .setPasswordAndVerify("TestPassword123");
    }

    @Test
    @DisplayName("Successful user registration")
    @Story("Positive registration scenario")
    @Severity(SeverityLevel.BLOCKER)
    void successfulRegistrationTest() {
        registrationPage.openRegistrationPage()
                .setEmail(dataGenerator.getEmail())
                .setPassword("ValidPass123!")
                .submitRegistration()
                .verifySuccessfulRegistration();
    }

    @Test
    @DisplayName("'Start for free' button availability")
    @Story("UI Elements Verification")
    @Severity(SeverityLevel.MINOR)
    void startForFreeButtonTest() {
        open(WEB_CONFIG.baseUrl());
        registrationPage.verifyStartForFreeButtonVisible();
    }
}