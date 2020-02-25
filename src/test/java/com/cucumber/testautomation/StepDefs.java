package com.cucumber.testautomation;

import com.cucumber.testautomation.cucumber.World;
import com.cucumber.testautomation.webpages.webblocks.*;
import com.cucumber.testautomation.webpages.workspaces.CheckoutBlock;
import com.cucumber.testautomation.webpages.workspaces.FrontPage;
import com.cucumber.testautomation.webpages.workspaces.Footer;
import com.cucumber.testautomation.webpages.workspaces.Header;
import com.cucumber.testautomation.webpages.workspaces.CenterColumn;
import com.cucumber.testautomation.webpages.workspaces.LeftColumn;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefs {

    private World world;
    private FrontPage frontPage;

    public StepDefs(World world) {
        this.world = world;
    }

    @Given("the {string} page is shown")
    public void thePageIsShown(String pageName) {
        if (pageName.equals("Front Page")) {
            frontPage = new FrontPage(world.webDriver);
            assertTrue(world.webDriver.getCurrentUrl().contains(frontPage.getPageUrl()));
        } else {
            throw new NoSuchElementException("There is no such page - "+ pageName);
        }
    }

    @Given("the user clicks on {string} link on header block")
    public void theUserClicksOnLinkOnHeaderBlock(String linkName) throws Exception {
        if (linkName.equals("Sign in")){
            frontPage.getHeader().clickOnLoginButton();
        } else {
            throw new NoSuchElementException("There is no such button - "+ linkName);
        }
    }

    @And("the {string} block is shown")
    public void theBlockIsShown(String blockName) throws Exception {
        switch (blockName) {
            case "Authentication":
                assertTrue("The [" + blockName + "] is not shown on the page", frontPage.getCenterColumn().isAuthenticationHeaderPresent());
                break;
            case "Create An Account":
                assertTrue("The [" + blockName + "] is not shown on the page", frontPage.getCenterColumn().isCreateAccountFormPresent());
                break;
            case "My Account":

                break;
            default:
                throw new NoSuchElementException("There is no such block - " + blockName);
        }
    }

    @When("the user enters {string} into {string} field on Authentication block")
    public void theUserEntersIntoOnAuthenticationBlock(String value, String fieldName) throws Exception {
        if (fieldName.equals("Email Address")) {
            frontPage.getCenterColumn().populateEmailAddress(value);
        } else {
            throw new NoSuchElementException("There is no such field name - "+ fieldName);
        }
    }

    @And("the user clicks on {string} button on Authentication block")
    public void theUserClicksOnButtonOnAuthenticationBlock(String buttonName) throws Exception {
        if (buttonName.equals("Create an account")) {
            frontPage.getCenterColumn().clickOnCreateAccountButton();
        } else if (buttonName.equals("Register")) {
            frontPage.getCenterColumn().getAccountCreationBlock().clickOnRegisterButton();
        } else {
                throw new NoSuchElementException("There is no such button name - "+ buttonName);
            }
    }

    @When("the user fills in all mandatory fields")
    public void theUserFillsInAllMandatoryFields() throws Exception {
        frontPage.getCenterColumn().getAccountCreationBlock().populateMandatoryFieldsWithDefaultValues();
    }

    @Given("the user enters {string} into Search field on header block")
    public void theUserEntersIntoSearchFieldOnHeaderBlock(String value) throws Exception {
        frontPage.getHeader().populateValueInSearchField(value);
    }

    @And("the user clicks on {string} button on header block")
    public void theUserClicksOnButtonOnHeaderBlock(String buttonName) throws Exception {
        if (buttonName.equals("Search")) {
            frontPage.getHeader().clickOnSearchButton();
        } else {
            throw new NoSuchElementException("There is no such button name - "+ buttonName);
        }
    }

    @And("the Search header shows {string} and {string}")
    public void theSearchHeaderShowsAnd(String searchValue, String message) throws Exception {
        assertEquals("\""+searchValue+"\"", frontPage.getCenterColumn().getSearchHeaderText());
        assertEquals(message, frontPage.getCenterColumn().getSearchHeaderMessageText());
    }

    @And("the product list grid contains {string} item")
    public void theProductListGridContainsItem(String value) throws Exception {
        assertTrue("Grid doesn't contain element - "+ value, frontPage.getCenterColumn().getProductListGrid().isProductInGridList(value));
    }

    @When("the user clicks on {string} button against {string} item on product list grid")
    public void theUserClicksOnButtonAgainstItemOnProductListGrid(String buttonName, String productValue) throws Exception {
        if (buttonName.equals("Add to cart")) {
            frontPage.getCenterColumn().getProductListGrid().clickAddToCartButton(productValue);
        } else {
            throw new NoSuchElementException("There is no such button name - "+ buttonName);
        }
    }

    @Then("the {string} is shown")
    public void theIsShown(String blockName) throws Exception {
        if (blockName.equals("Product Layer Cart")) {
            assertTrue("The Product Layer Cart is not present", frontPage.getHeader().isLayerCartPresent());
        } else if (blockName.equals("Category block")) {
            assertTrue("The Category block is not present", frontPage.getLeftColumn().isCategoryBlockPresent());
        } else if (blockName.equals("Product List grid")) {
            assertTrue("The Product List grid is not present", frontPage.getCenterColumn().isProductListGridPresent());
        } else {
            throw new NoSuchElementException("There is no such block name - " + blockName);
        }
    }

    @When("the user clicks on {string} button on Product Layer Cart")
    public void theUserClicksOnButtonOnProductLayerCart(String arg0) throws Exception {
        frontPage.getHeader().getLayerCart().clickOnProceedToCheckout();
    }

    @Then("the {string} form is shown on Checkout page")
    public void theFormIsShownOnCheckoutPage(String formName) throws Exception {
        switch (formName) {
            case "Summary":
                assertTrue("There is no such block name - "+formName, frontPage.getCheckoutSummary().getHeaderText().contains(formName.toUpperCase()));
                break;
            case "Address":
                assertTrue("There is no such block name - "+formName, frontPage.getCheckoutAddress().getHeaderText().contains(formName.toUpperCase()));
                break;
            case "Shipping":
                assertTrue("There is no such block name - "+formName, frontPage.getCheckoutShipping().getHeaderText().contains(formName.toUpperCase()));
                break;
            case "Payment":
                assertTrue("There is no such block name - "+formName, frontPage.getCheckoutPayment().getHeaderText().contains(formName.toUpperCase()));
                break;
            default:
                throw new NoSuchElementException("There is no such form name - " + formName);
        }
    }

    @And("the user clicks on Proceed to checkout button on {string} form")
    public void theUserClicksOnProceedToCheckoutButtonOnForm(String formName) throws Exception {
        switch (formName) {
            case "Summary":
                frontPage.getCheckoutSummary().clickOnProceedToCheckoutButton();
                break;
            case "Address":
                frontPage.getCheckoutAddress().clickOnProceedToCheckoutButton();
                break;
            case "Shipping":
                frontPage.getCheckoutShipping().clickOnProceedToCheckoutButton();
                break;
            case "Payment":
                frontPage.getCheckoutPayment().clickOnProceedToCheckoutButton();
                break;
            default:
                throw new NoSuchElementException("There is no such form name - " + formName);
        }
    }

    @When("the user clicks on {string} checkbox on Shipping form")
    public void theUserClicksOnCheckboxOnShippingForm(String checkboxName) throws Exception {
        if (checkboxName.equals("Agree")) {
            frontPage.getCheckoutShipping().clickOnAgreeCheckBox();
        }
    }

    @When("the user clicks on {string} button on Payment form")
    public void theUserClicksOnButtonOnPaymentForm(String buttonName) throws Exception {
        if (buttonName.equals("Pay by Bank wire")) {
            frontPage.getCheckoutPayment().clickOnPayByBankWireButton();
        } else if (buttonName.equals("I confirm my order")) {
            frontPage.getCheckoutPayment().clickOnConfirmOrderButton();
        }
    }

    @Then("the {string} is shown on the Payment page")
    public void theIsShownOnThePaymentPage(String message) throws Exception {
        assertEquals(message, frontPage.getCheckoutPayment().getConfirmationOrderTitleText());
    }

    @When("the user clicks on {string} on Category block")
    public void theUserClicksOnOnCategoryBlock(String categoryValue) throws Exception {
        frontPage.getLeftColumn().getCategoryBlockLeft().clickOnCategory(categoryValue);
    }

    @Given("the user navigates with top menu to {string}")
    public void theUserNavigatesWithTopMenuTo(String categoryName) throws Exception {
        frontPage.getHeader().getTopMenu().selectCategoryOnMenu(categoryName.toUpperCase());
    }
}
