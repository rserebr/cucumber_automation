package com.cucumber.testautomation.webpages.workspaces;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Footer extends BasePage {

    public Footer(WebDriver webDriver, DefaultElementLocatorFactory footer) throws Exception {
        if (footer == null) {
            throw new Exception("Footer section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, defaultWaitTimer);
        PageFactory.initElements(footer, this);
    }
}
