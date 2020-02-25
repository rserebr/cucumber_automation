package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CategoryBlockLeft extends BasePage {

    @FindBy(xpath = ".//ul/li") List<WebElement> leftMenuCategories;

    public CategoryBlockLeft(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Left Category block cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }

    public void clickOnCategory(String categoryValue) {
        leftMenuCategories.stream().filter(e -> e.getText().equals(categoryValue)).findFirst().get().click();
    }
}
