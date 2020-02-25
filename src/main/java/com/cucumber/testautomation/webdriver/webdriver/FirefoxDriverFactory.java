package com.cucumber.testautomation.webdriver.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Optional;

public class FirefoxDriverFactory extends AbstractWebDriverFactory {

    @Override
    String driverFilePropertyName() {
        return "webdriver.gecko.driver";
    }
    @Override
    Optional<String> macFile() {
        return Optional.of("geckodriver");
    }
    @Override
    Optional<String> windowsFile() {
        return Optional.of("geckodriver.exe");
    }
    @Override
    Optional<String> linuxFile() {
        return Optional.of("geckodriver");
    }
    @Override
    public WebDriver createWebDriver(boolean headless) {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if(headless) {
            FirefoxBinary firefoxBinary = new FirefoxBinary();
            firefoxBinary.addCommandLineOptions("--headless");
            firefoxOptions.setBinary(firefoxBinary);
        }
        return new FirefoxDriver(firefoxOptions);
    }
}
