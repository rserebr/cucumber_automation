package com.cucumber.testautomation.webpages.workspaces;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import com.cucumber.testautomation.webpages.webblocks.LayerCart;
import com.cucumber.testautomation.webpages.webblocks.TopMenuBlock;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {

    private LayerCart layerCart;
    private TopMenuBlock topMenu;
    private DefaultElementLocatorFactory parentContext;

    @FindBy(xpath = "//*[@class='banner']") WebElement headerBanner;
    @FindBy(xpath = "//*[@class='account']") WebElement headerAccountLink;
    @FindBy(xpath = "//*[@class='logout']") WebElement headerLogoutLink;
    @FindBy(xpath = "//*[@class='login']") WebElement headerLoginLink;
    @FindBy(xpath = "//*[@id='contact-link']") WebElement headerContactUsLink;
    @FindBy(xpath = "//*[@class='shop-phone']") WebElement headerShopPhone;
    @FindBy(xpath = "//*[@id='header_logo']") WebElement headerLogo;
    @FindBy(xpath = "//*[@id='search_query_top']") WebElement headerSearchField;
    @FindBy(xpath = "//*[@name='submit_search']") WebElement headerSearchSubmitButton;
    @FindBy(xpath = "//*[@class='shopping_cart']") WebElement headerShoppingCart;
    @FindBy(xpath = "//*[@id='block_top_menu']") WebElement headerBlockTopMenu;

    @FindBy(xpath = "//*[@id='layer_cart']") WebElement layerCartBlock;
    @FindBy(xpath = "//*[@id='block_top_menu']") WebElement topMenuSection;

    public Header(WebDriver webDriver, DefaultElementLocatorFactory parentContext) throws Exception {
        if (parentContext == null) {
            throw new Exception("Header section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(parentContext, this);
    }

    public void clickOnLoginButton() {
        clickOnTheButton(headerLoginLink);
    }

    public void populateValueInSearchField(String value) {
        populateField(headerSearchField, value);
    }

    public void clickOnSearchButton() {
        clickOnTheButton(headerSearchSubmitButton);
    }

    public LayerCart getLayerCart() throws Exception {
        if (layerCart==null){
            parentContext = new DefaultElementLocatorFactory(layerCartBlock);
            layerCart = new LayerCart(webDriver, parentContext);
        }
        return layerCart;
    }

    public TopMenuBlock getTopMenu() throws Exception {
        if (topMenu ==null){
            parentContext = new DefaultElementLocatorFactory(topMenuSection);
            topMenu = new TopMenuBlock(webDriver, parentContext);
        }
        return topMenu;
    }

    public boolean isLayerCartPresent() {
        return webDriverWait.until(ExpectedConditions.visibilityOf(layerCartBlock)).isDisplayed();
    }

}
