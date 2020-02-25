package com.cucumber.testautomation.webpages.webblocks;

import com.cucumber.testautomation.utils.UserDataBuilder;
import com.cucumber.testautomation.webdriver.webpages.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreationForm extends BasePage {

    @FindBy(xpath = ".//*[@id='customer_lastname']") WebElement lastNameField;
    @FindBy(xpath = ".//*[@id='customer_firstname']") WebElement firstNameField;
    @FindBy(xpath = ".//*[@id='passwd']") WebElement passwordField;
    @FindBy(xpath = ".//*[@id='days']") WebElement daysDropDownField;
    @FindBy(xpath = ".//*[@id='months']") WebElement monthsDropDownField;
    @FindBy(xpath = ".//*[@id='years']") WebElement yearsDropDownField;
    @FindBy(xpath = ".//*[@id='address1']") WebElement addressOneField;
    @FindBy(xpath = ".//*[@id='city']") WebElement cityField;
    @FindBy(xpath = ".//*[@id='id_state']") WebElement stateDropDownField;
    @FindBy(xpath = ".//*[@id='postcode']") WebElement postCodeField;
    @FindBy(xpath = ".//*[@id='id_country']") WebElement countryDropDownField;
    @FindBy(xpath = ".//*[@id='phone_mobile']") WebElement mobilePhoneField;
    @FindBy(xpath = ".//*[@id='submitAccount']") WebElement registerButton;

    public AccountCreationForm(WebDriver webDriver, DefaultElementLocatorFactory accountCreationForm) throws Exception {
        if (accountCreationForm == null) {
            throw new Exception("Account Creation Form section cannot be null.");
        }
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitTimer);
        PageFactory.initElements(accountCreationForm, this);
    }

    public void clickOnRegisterButton() {
        clickOnTheButton(registerButton);
    }

    public void populateMandatoryFieldsWithDefaultValues() {
        UserDataBuilder userData = new UserDataBuilder.Builder().build();
        populateMandatoryFieldsWithValues(userData);
    }

    private void populateMandatoryFieldsWithValues(UserDataBuilder userData) {
        populateField(firstNameField, userData.getFirstName());
        populateField(lastNameField, userData.getLastName());
        populateField(passwordField, userData.getPassword());
        selectDropDownValue(daysDropDownField, userData.getDay());
        selectDropDownValue(monthsDropDownField, userData.getMonth());
        selectDropDownValue(yearsDropDownField, userData.getYear());
        populateField(addressOneField, userData.getAddressOne());
        populateField(cityField, userData.getCity());
        selectDropDownValue(stateDropDownField, userData.getState());
        populateField(postCodeField, userData.getZip());
        selectDropDownValue(countryDropDownField, userData.getCountry());
        populateField(mobilePhoneField, userData.getMobile());
    }
}
