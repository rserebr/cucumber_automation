package com.cucumber.testautomation.cucumber;

import com.cucumber.testautomation.webdriver.WebPageTest;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class WebHooks {

    private World world;

    public WebHooks(World world) {
        this.world = world;
    }

    @Before("@web")
    public void initWebDriver() {
        world.webDriver = WebPageTest.getWebDriver();
        world.configProperties = WebPageTest.getConfigProperties();
    }

    @After(value = "@web", order = 100)
    public void quitWebDriver() {
        world.webDriver.quit();
    }

    @After(value = "@web", order = 101)
    public void takeScreenShot(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) world.webDriver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }
}
