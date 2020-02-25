package com.cucumber.testautomation.webpages.workspaces;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import com.cucumber.testautomation.webpages.webblocks.CategoryBlockLeft;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LeftColumn extends BasePage {

    @FindBy(xpath = ".//*[@id='categories_block_left']") WebElement categoryBlockleftSection;

    private CategoryBlockLeft categoryBlockleft;
    private DefaultElementLocatorFactory parentContext;


    public LeftColumn(WebDriver webDriver, DefaultElementLocatorFactory leftColumn) throws Exception {
        if (leftColumn == null) {
            throw new Exception("Left Column section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, defaultWaitTimer);
        PageFactory.initElements(leftColumn, this);
    }

    public CategoryBlockLeft getCategoryBlockLeft() throws Exception {
        if (categoryBlockleft ==null){
            parentContext = new DefaultElementLocatorFactory(categoryBlockleftSection);
            categoryBlockleft = new CategoryBlockLeft(webDriver, parentContext);
        }
        return categoryBlockleft;
    }

    public boolean isCategoryBlockPresent() {
        return webDriverWait.until(ExpectedConditions.visibilityOf(categoryBlockleftSection)).isDisplayed();
    }
}
