package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.stream.Collectors;

public class ProductListGrid extends BasePage {

    @FindBy(xpath = "./li") List<WebElement> productGridList;

    public ProductListGrid(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Product List Grid section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }

    public boolean isProductInGridList(String value) {
        return getProductNamesList().contains(value);
    }

    private List<String> getProductNamesList() {
        return productGridList.stream().map(e -> e.findElement(By.xpath(".//a[@class='product-name']")).getText()).collect(Collectors.toList());
    }

    public void clickAddToCartButton(String productValue) {
        Actions action = new Actions(webDriver);
        action.moveToElement(getProductElement(productValue)).perform();
        clickOnTheButton(getProductAddToCartButton(productValue));

    }

    private WebElement getProductAddToCartButton(String productValue) {
        return getProductElement(productValue).findElement(By.xpath(".//*[contains(@class, 'add_to_cart')]"));
    }

    private WebElement getProductElement(String productValue) {
        return productGridList.stream().filter(e -> e.findElement(By.xpath(".//a[@class='product-name']")).getText().equals(productValue)).findFirst().get();
    }
}
