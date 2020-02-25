package com.cucumber.testautomation.webpages.workspaces;

import com.cucumber.testautomation.webpages.webblocks.AccountCreationForm;
import com.cucumber.testautomation.webdriver.webpages.BasePage;
import com.cucumber.testautomation.webpages.webblocks.ProductListGrid;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CenterColumn extends BasePage {

    @FindBy(xpath = ".//*[@id='account-creation_form']") WebElement accountCreationBlock;

    @FindBy(xpath = ".//h1[text()='Authentication']") WebElement authenticationHeader;
    @FindBy(xpath = ".//input[@id='email_create']") WebElement createEmailAddressField;
    @FindBy(xpath = ".//button[@id='SubmitCreate']") WebElement createAccountButton;
    @FindBy(xpath = ".//h1/span[@class= 'lighter']") WebElement searchHeaderValue;
    @FindBy(xpath = ".//h1/span[@class= 'heading-counter']") WebElement searchHeaderMessage;
    @FindBy(xpath = ".//ul[contains(@class, 'product_list')]") WebElement productListGridBlock;
    @FindBy(xpath = ".//*[@id='center_column']/p/a[1]") WebElement proceedToCheckoutButton;

    private AccountCreationForm accountCreationForm;
    private ProductListGrid productListGrid;
    private DefaultElementLocatorFactory parentContext;

    public CenterColumn(WebDriver webDriver, DefaultElementLocatorFactory centerColumn) throws Exception {
        if (centerColumn == null) {
            throw new Exception("Center Column section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(this.webDriver, defaultWaitTimer);
        PageFactory.initElements(centerColumn, this);
    }

    public AccountCreationForm getAccountCreationBlock() throws Exception {
        if (accountCreationForm==null){
            parentContext = new DefaultElementLocatorFactory(accountCreationBlock);
            accountCreationForm = new AccountCreationForm(webDriver, parentContext);
        }
        return accountCreationForm;
    }

    public ProductListGrid getProductListGrid() throws Exception {
        if (productListGrid==null){
            parentContext = new DefaultElementLocatorFactory(productListGridBlock);
            productListGrid = new ProductListGrid(webDriver, parentContext);
        }
        return productListGrid;
    }

    public boolean isAuthenticationHeaderPresent() {
        return isElementPresent(authenticationHeader);
    }

    public void populateEmailAddress(String value) {
        if (value.contains("@UNIQUE")) {
            value = System.currentTimeMillis()+"_auto@mail.com";
        }
        populateField(createEmailAddressField, value);
    }

    public void clickOnCreateAccountButton() {
        clickOnTheButton(createAccountButton);
    }

    public boolean isCreateAccountFormPresent() {
        return isElementPresent(accountCreationBlock);
    }

    public String getSearchHeaderText() {
        return getElementText(searchHeaderValue);
    }

    public String getSearchHeaderMessageText() {
        return getElementText(searchHeaderMessage);
    }


    public void clickOnProceedToCheckoutButton() {
        clickOnTheButton(proceedToCheckoutButton);
    }

    public boolean isProductListGridPresent() {
        return webDriverWait.until(ExpectedConditions.visibilityOf(productListGridBlock)).isDisplayed();
    }
}
