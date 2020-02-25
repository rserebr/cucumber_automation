package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.webpages.workspaces.CheckoutBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutShipping extends CheckoutBlock {

    @FindBy(xpath = ".//*[@id='cgv']") WebElement agreeCheckbox;

    public CheckoutShipping(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Checkout Shipping section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }

    public void clickOnAgreeCheckBox() {
        agreeCheckbox.click();
    }
}
