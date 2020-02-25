package com.cucumber.testautomation.webpages.workspaces;

import com.cucumber.testautomation.webdriver.webpages.BasePage;
import com.cucumber.testautomation.webpages.webblocks.CheckoutAddress;
import com.cucumber.testautomation.webpages.webblocks.CheckoutPayment;
import com.cucumber.testautomation.webpages.webblocks.CheckoutShipping;
import com.cucumber.testautomation.webpages.webblocks.CheckoutSummary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrontPage extends BasePage {

    @FindBy(xpath = ".//*[@id='header']") WebElement headerBlock;
    @FindBy(xpath = "//*[@id='footer']") WebElement footerBlock;
    @FindBy(xpath = "//*[@id='columns']") WebElement columnsBlock;
    @FindBy(xpath = ".//*[@id='left_column']") WebElement leftColumnBlock;
    @FindBy(xpath = ".//*[@id='center_column']") WebElement centerColumnBlock;

    private Header header;
    private Footer footer;
    private CenterColumn centerColumn;
    private LeftColumn leftColumn;
    private CheckoutSummary checkoutSummary;
    private CheckoutAddress checkoutAddress;
    private CheckoutPayment checkoutPayment;
    private CheckoutShipping checkoutShipping;
    private DefaultElementLocatorFactory parentContext;

    public FrontPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.pageUrl = "/index.php";
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(webDriver, this);
    }

    public Header getHeader() throws Exception {
        if (header==null){
            parentContext = new DefaultElementLocatorFactory(headerBlock);
            header = new Header(webDriver, parentContext);
        }
        return header;
    }

    public Footer getFooter() throws Exception {
        if (footer==null){
            parentContext = new DefaultElementLocatorFactory(footerBlock);
            footer = new Footer(webDriver, parentContext);
        }
        return footer;
    }

    public CenterColumn getCenterColumn() throws Exception {
        if (centerColumn==null){
            parentContext = new DefaultElementLocatorFactory(centerColumnBlock);
            centerColumn = new CenterColumn(webDriver, parentContext);
        }
        return centerColumn;
    }

    public LeftColumn getLeftColumn() throws Exception {
        if (leftColumn==null){
            parentContext = new DefaultElementLocatorFactory(leftColumnBlock);
            leftColumn = new LeftColumn(webDriver, parentContext);
        }
        return leftColumn;
    }

    public CheckoutSummary getCheckoutSummary() throws Exception {
        if (checkoutSummary ==null){
            parentContext = new DefaultElementLocatorFactory(centerColumnBlock);
            checkoutSummary = new CheckoutSummary(webDriver, parentContext);
        }
        return checkoutSummary;
    }

    public CheckoutAddress getCheckoutAddress() throws Exception {
        if (checkoutAddress ==null){
            parentContext = new DefaultElementLocatorFactory(centerColumnBlock);
            checkoutAddress = new CheckoutAddress(webDriver, parentContext);
        }
        return checkoutAddress;
    }

    public CheckoutPayment getCheckoutPayment() throws Exception {
        if (checkoutPayment ==null){
            parentContext = new DefaultElementLocatorFactory(centerColumnBlock);
            checkoutPayment = new CheckoutPayment(webDriver, parentContext);
        }
        return checkoutPayment;
    }

    public CheckoutShipping getCheckoutShipping() throws Exception {
        if (checkoutShipping ==null){
            parentContext = new DefaultElementLocatorFactory(centerColumnBlock);
            checkoutShipping = new CheckoutShipping(webDriver, parentContext);
        }
        return checkoutShipping;
    }



}
