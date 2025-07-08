package tests.mobile;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.mobile.pageObjects.LoginPage;

@Tag("MOBILE")
@Tag("ALL")
@Epic("Mobile Authentication")
@Feature("Login Functionality")
public class LoginTests extends TestBase {
    private final LoginPage loginPage = new LoginPage();

    @Test
    @DisplayName("Check login form elements")
    @Story("UI Verification")
    @Severity(SeverityLevel.MINOR)
    void loginFormElementsTest() {
        loginPage.openLoginPage();
        loginPage.checkEmailInputVisible();
    }
}