package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.webpages.workspaces.CheckoutBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutSummary extends CheckoutBlock {

    public CheckoutSummary(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Checkout Summary section cannot be null.");
            }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }


}
