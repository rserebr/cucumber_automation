package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LayerCart extends BasePage {

    @FindBy(xpath = ".//*[@class='button-container']/a") WebElement proceedToCheckoutButton;

    public LayerCart(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Layer Cart section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }

    public void clickOnProceedToCheckout() {
        clickOnTheButton(proceedToCheckoutButton);
    }
}
