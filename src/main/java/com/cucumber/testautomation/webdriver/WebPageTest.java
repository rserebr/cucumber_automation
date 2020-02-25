package com.cucumber.testautomation.webdriver;

import com.cucumber.testautomation.webdriver.filesystem.RecursiveFileFinder;
import com.cucumber.testautomation.webdriver.webdriver.Browser;
import com.cucumber.testautomation.webdriver.webdriver.SeleniumUtils;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public class WebPageTest {

    private ConfigProperties configProperties = new ConfigProperties();
    private RecursiveFileFinder fileFinder = new RecursiveFileFinder();
    private WebDriver driver;

    public WebPageTest() {
        Optional<File> configFile = fileFinder.findFile(".", "config.properties");
        configFile.ifPresent(file -> this.configProperties = new ConfigProperties(file));
    }

    private void openBrowser(Browser browser, boolean headless) {
        String url = this.configProperties.getProperty("url", "http://automationpractice.com");
        openBrowser(browser, url, headless);
    }

    private void openBrowser(Browser browser, String url, boolean headless) {
        driver = SeleniumUtils.getWebDriver(browser, headless);
        driver.navigate().to(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }

    public static WebDriver getWebDriver() {
        WebPageTest webPageTest = new WebPageTest();
        Browser browser = Browser.valueOf(webPageTest.configProperties.getProperty("browser", "chrome").toUpperCase());
        boolean headless = Boolean.parseBoolean(webPageTest.configProperties.getProperty("headless", "false"));
        return WebPageTest.getWebDriver(browser, headless);
    }

    public static WebDriver getWebDriver(Browser browser, boolean headless) {
        WebPageTest webPageTest = new WebPageTest();
        webPageTest.openBrowser(browser, headless);
        return webPageTest.driver;
    }

    public static ConfigProperties getConfigProperties() {
        WebPageTest webPageTest = new WebPageTest();
        return webPageTest.configProperties;
    }
}
