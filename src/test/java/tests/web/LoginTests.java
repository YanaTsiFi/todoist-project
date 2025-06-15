package tests.web;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.web.pageObjects.LoginPage;


@Tag("WEB")
@Tag("ALL")
@Epic("User Authentication")
@Feature("Login Functionality")
public class LoginTests extends TestBase {
    private final LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Successful login with valid credentials")
    @Story("Positive login scenario")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("QA Team")
    void successfulLoginTest() {
        loginPage.openLoginPage()
                .doLogin(WEB_CONFIG.login(), WEB_CONFIG.password())
                .checkCurrentUrl();
    }

    @Test
    @DisplayName("Failed login with invalid password")
    @Story("Negative login scenario")
    @Severity(SeverityLevel.CRITICAL)
    void unsuccessfulLoginTest() {
        loginPage.openLoginPage()
                .doLogin(WEB_CONFIG.login(), "wrongPassword123")
                .checkErrorMessage("Wrong email or password.");
    }

    @Test
    @DisplayName("Login button visibility check")
    @Story("UI Elements Verification")
    @Severity(SeverityLevel.MINOR)
    void loginButtonVisibilityTest() {
        loginPage.openLoginPage()
                .checkLoginButtonVisible();
    }
}