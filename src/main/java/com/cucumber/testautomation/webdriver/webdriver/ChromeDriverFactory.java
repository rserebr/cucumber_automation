package com.cucumber.testautomation.webdriver.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Optional;

public class ChromeDriverFactory extends AbstractWebDriverFactory {

    @Override
    String driverFilePropertyName() {
        return "webdriver.chrome.driver";
    }
    @Override
    Optional<String> macFile() {
        return Optional.of("chromedriver");
    }
    @Override
    Optional<String> windowsFile() {
        return Optional.of("chromedriver.exe");
    }
    @Override
    Optional<String> linuxFile() {
        return Optional.of("chromedriver");
    }
    @Override
    public WebDriver createWebDriver(boolean headless) {
        ChromeOptions chromeOptions = new ChromeOptions();
        if(headless) {
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-browser-side-navigation");
            chromeOptions.addArguments("--disable-gpu");
        }
        return new ChromeDriver(chromeOptions);
    }
}
