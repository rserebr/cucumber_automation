package com.cucumber.testautomation.webdriver.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public abstract class BasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    protected String pageUrl;
    protected int defaultWaitTimer = 10;

    protected void clickOnTheButton(WebElement button) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }

    protected String getElementText(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void populateField(WebElement fieldElement, String value) {
        webDriverWait.until(ExpectedConditions.visibilityOf(fieldElement)).clear();
        fieldElement.sendKeys(value);
    }

    protected boolean isElementPresent(WebElement element) {
        return webDriverWait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    protected void selectDropDownValue(WebElement dropDownElement, String value) {
        Select dropDown = new Select(dropDownElement);
        dropDown.selectByValue(value);
    }

    public String getPageUrl() {
        return pageUrl;
    }


}
