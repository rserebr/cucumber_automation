package com.cucumber.testautomation.webpages.workspaces;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public abstract class CheckoutBlock extends BasePage {

    @FindBy(xpath = ".//*[contains(text(), 'Proceed to checkout')]/..") WebElement proceedToCheckoutButton;
    @FindBy(xpath = ".//h1") WebElement formHeader;

    public void clickOnProceedToCheckoutButton() {
        clickOnTheButton(proceedToCheckoutButton);
    }

    public String getHeaderText() {
        return getElementText(formHeader);
    }
}
