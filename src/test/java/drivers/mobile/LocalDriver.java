package drivers.mobile;


import com.codeborne.selenide.WebDriverProvider;
import config.mobile.LocalConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class LocalDriver implements WebDriverProvider {

    private static final LocalConfig config = ConfigFactory.create(LocalConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setPlatformName(config.platformName());
        options.setDeviceName(config.deviceName());
        options.setPlatformVersion(config.platformVersion());
        System.out.println("Config values:");
        System.out.println("appPath: " + config.appPath());
        System.out.println("appiumUrl: " + config.appiumUrl());

        // Проверка существования APK файла
        File app = new File(Objects.requireNonNull(config.appPath(), "App path must not be null"));
        if (!app.exists()) {
            throw new RuntimeException("APK file not found at: " + app.getAbsolutePath());
        }
        options.setPlatformName(config.platformName());
        options.setDeviceName(config.deviceName());
        options.setPlatformVersion(config.platformVersion());
        options.setApp(app.getAbsolutePath()); // Используем абсолютный путь
        options.setAppPackage(config.appPackage());
        options.setAppActivity(config.appActivity());
        options.setAutomationName(config.automationName());

        try {
            return new AndroidDriver(new URL(config.appiumUrl()), options);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }
}