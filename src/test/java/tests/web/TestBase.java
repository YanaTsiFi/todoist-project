package tests.web;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.web.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static config.web.WebConfig.getInstance;

public class TestBase {
    protected static final WebConfig WEB_CONFIG = getInstance();
    protected static final String BASE_URL = "https://todoist.com/";

    @BeforeAll
    static void setupAll() {
        Configuration.baseUrl = BASE_URL;
        Configuration.browser = WEB_CONFIG.browser();
        Configuration.browserVersion = WEB_CONFIG.browserVersion();
        Configuration.browserSize = WEB_CONFIG.browserSize();
        Configuration.timeout = WEB_CONFIG.timeout();
        Configuration.remote = WEB_CONFIG.remoteUrl();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true));
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        WebDriverRunner.closeWebDriver();
    }
}