package tests.mobile;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import tests.mobile.pageObjects.OnboardingPage;

@Tag("MOBILE")
@Epic("Onboarding Flow")
public class OnboardingTests extends TestBase {
    private final OnboardingPage onboarding = new OnboardingPage();

    @Test
    @DisplayName("Verify Todoist logo")
    @Story("UI Validation")
    @Severity(SeverityLevel.CRITICAL)
    void verifyLogo() {
        onboarding.verifyLogo();
    }

    @Test
    @DisplayName("Verify text on second screen")
    @Story("Content Validation")
    @Severity(SeverityLevel.CRITICAL)
    void verifySecondScreenContent() {
        onboarding
                .verifyLogo()
                .clickContinueButton()
                .verifySecondScreenText();
    }
}