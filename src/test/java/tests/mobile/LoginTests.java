package tests.mobile;

import config.mobile.BrowserstackConfig;
import config.mobile.LocalConfig;
import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.mobile.pageObjects.LoginPage;
import org.aeonbits.owner.ConfigFactory;

@Tag("MOBILE")
@Epic("Mobile Authentication")
@Feature("Login Functionality")
public class LoginTests extends TestBase {
    private final LoginPage loginPage = new LoginPage();
    private final LocalConfig localConfig = ConfigFactory.create(LocalConfig.class);
    private final BrowserstackConfig bsConfig = ConfigFactory.create(BrowserstackConfig.class);

    @Test
    @DisplayName("Check login form elements")
    @Story("UI Verification")
    @Severity(SeverityLevel.MINOR)
    void loginFormElementsTest() {
        loginPage.openLoginPage();
        loginPage.checkEmailInputVisible();
    }
}