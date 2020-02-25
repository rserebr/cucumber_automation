package com.cucumber.testautomation.webdriver.webdriver;

import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public class SeleniumUtils {

    private static Map<Browser, AbstractWebDriverFactory > webDriverFactories = new HashMap<>();

    static {
        webDriverFactories.put(Browser.CHROME, new ChromeDriverFactory());
        webDriverFactories.put(Browser.FIREFOX, new FirefoxDriverFactory());
    }

    private SeleniumUtils() {}

    public static WebDriver getWebDriver(Browser browser) {
        return getWebDriver(browser, false);
    }

    public static WebDriver getWebDriver(Browser browser, boolean headless) {
        AbstractWebDriverFactory  factory = webDriverFactories.get(browser);
        return factory.loadAndCreateWebDriver(headless);
    }
}
