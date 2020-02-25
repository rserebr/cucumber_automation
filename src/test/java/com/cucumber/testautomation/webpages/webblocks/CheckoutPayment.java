package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.webpages.workspaces.CheckoutBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPayment extends CheckoutBlock {

    @FindBy(xpath = ".//*[@class='bankwire']") WebElement payByBankWireButton;
    @FindBy(xpath = ".//button") WebElement confirmOrderButton;
    @FindBy(xpath = ".//div/p") WebElement confirmationMessage;

    public CheckoutPayment(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Checkout Payment section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }

    public void clickOnPayByBankWireButton() {
        clickOnTheButton(payByBankWireButton);
    }

    public void clickOnConfirmOrderButton() {
        clickOnTheButton(confirmOrderButton);
    }

    public String getConfirmationOrderTitleText() {
        return getElementText(confirmationMessage);
    }
}
