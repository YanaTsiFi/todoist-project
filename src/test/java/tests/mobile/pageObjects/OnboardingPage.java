package tests.mobile.pageObjects;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OnboardingPage {

    private final SelenideElement logo = $(AppiumBy.xpath(
            "//*[contains(@resource-id, 'logo') or @content-desc='Todoist Logo']"
    ));

    private final SelenideElement continueButton = $(AppiumBy.xpath(
            "//android.widget.LinearLayout[contains(@clickable, 'true')]"
    ));

    private final SelenideElement secondScreenText = $(AppiumBy.xpath(
            "//*[contains(@text, 'My tasks used to be scattered') or " +
                    "contains(@content-desc, 'My tasks used to be scattered')]"
    ));

    @Step("Verify Todoist logo is visible")
    public OnboardingPage verifyLogo() {
        logo.shouldBe(visible, Duration.ofSeconds(10));
        return this;
    }

    @Step("Click continue button")
    public OnboardingPage clickContinueButton() {
        continueButton
                .shouldBe(visible, Duration.ofSeconds(10))
                .shouldBe(enabled, Duration.ofSeconds(10))
                .click();
        return this;
    }

    @Step("Verify second screen text appears")
    public OnboardingPage verifySecondScreenText() {
        secondScreenText.shouldBe(visible, Duration.ofSeconds(15));
        secondScreenText.shouldHave(text(
                "My tasks used to be scattered all around. Now, they"));
        return this;
    }
}