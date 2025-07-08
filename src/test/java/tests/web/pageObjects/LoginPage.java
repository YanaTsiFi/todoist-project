package tests.web.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


public class LoginPage {

    private final SelenideElement
            inputUsername = $("input[autocomplete='email']"),
            inputPassword = $("input[autocomplete='current-password']"),
            loginButton = $("button[type='submit']");

    @Step("Open login page")
    public LoginPage openLoginPage() {
        open("/auth/login");
        return this;
    }

    @Step("Login with {login}")
    public LoginPage doLogin(String login, String password) {
        inputUsername.setValue(login);
        inputPassword.setValue(password);
        loginButton.click();
        return this;
    }

    @Step("Verify login button visibility")
    public void checkLoginButtonVisible() {
        loginButton.shouldBe(visible);
    }

    @Step("Verify current URL")
    public void checkCurrentUrl() {
        webdriver().shouldHave(urlContaining("/app"));
    }

    @Step("Verify error message: {expectedText}")
    public void checkErrorMessage(String expectedText) {
        $(byText(expectedText)).shouldBe(visible);
    }
}