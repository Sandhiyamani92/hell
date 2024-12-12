
package com.sts.testautomation.pages.web;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sts.testautomation.utilities.ElementFunctionality;

public class LoginPage {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public LoginPage(WebDriver browserDriver, String Device) {
        BrowserDriver = browserDriver;
        this.Device = Device;
        verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    //################################### PAGE LINKS XPATHS SETUPS ###############################

    @FindBy(xpath = ("//*[@id=\"ContentLogin_ucLoginForm_LoginUser_UserName\"]"))
    private WebElement usernameInput;

    @FindBy(xpath = ("//*[@id=\"ContentLogin_ucLoginForm_LoginUser_Password\"]"))
    private WebElement passwordInput;

    @FindBy(xpath = ("//*[@id=\"ContentLogin_ucLoginForm_LoginUser_btnGetAuthType\"]"))
    private WebElement continueButton;
    
    @FindBy(xpath = ("//*[@id=\"ContentLogin_ucLoginForm_LoginUser_btnLogin\"]"))
    private WebElement loginButton;

    @FindBy(xpath = ("//div[@class='fade alert alert-danger alert-dismissible show']"))
    private WebElement errorMsg;

    @FindBy(xpath = ("//div[@class='LoginLayoutstyles__StyledContainer-sc-zoom2o-0 dfdhfe']"))
    private WebElement backgroundImageElement;

    @FindBy(xpath = ("//div[@class='Loginstyles__AuthCardLogo-sc-qt5242-7 fSfYuF']"))
    private WebElement hollardLogo;

    @FindBy(xpath = ("//a[@id='link-reset']"))
    private WebElement forgotPasswordElement;

    @FindBy(xpath = ("//a[@id='link-contact-us']"))
    private WebElement contactUsElement;

    @FindBy(xpath = ("(//span[@class='Loginstyles__FormError-sc-qt5242-10 fEsLtW'])[1]"))
    private WebElement emailFieldErrorElement;

    @FindBy(xpath = ("(//span[@class='Loginstyles__FormError-sc-qt5242-10 fEsLtW'])[2]"))
    private WebElement passwordFieldErrorElement;

    @FindBy(xpath = ("//div[@class='GenericMessagestyles__MessageContentConatainer-sc-69d6bo-3 bEzpca']"))
    private WebElement usernameAndPasswordFieldErrorElement;

    @FindBy (xpath=("//button[text()='EMPLOYEE LOGIN']"))
    private WebElement employeeLoginButton;




    public void verifyLoginPage() {

        verifyElement.verifyBrowserElement(usernameInput, "Username Input Box");
        verifyElement.verifyBrowserElement(passwordInput, "Password Input Box");
        verifyElement.verifyBrowserElement(loginButton, "Login Button");

    }

    public void getErrorMessage() {
        verifyElement.verifyBrowserElementValue(errorMsg, Device);
        System.out.println(errorMsg.getText());

    }

    public void clickLoginButton() {
        try {
            verifyElement.clickElement(loginButton, "Login Button");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public void clickContinueButton() {
        try {
            verifyElement.clickElement(continueButton, "Continue Button");
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void clickEmployeeLoginButton() {
    	verifyElement.clickElement(employeeLoginButton,"Employee Login");
    }

//    public void enterLoginCredentials(String username, String password) {
//
//        verifyElement.sendKeysWithClearNoEnter(usernameInput, "Username Input Box", username);
//        verifyElement.sendKeysWithClearNoEnter(passwordInput, "Password Input Box", password);
//
//    }

    public void enterUsername(String Username) {
        try {
            verifyElement.sendKeysWithClearNoEnter(usernameInput, "Username Input Box", Username);
        } catch (NullPointerException e) {
            e.printStackTrace();

    } catch (AssertionError e) {
        System.out.println(e.getMessage());
    }
    }

    public void enterPassword(String Password) {
        try {
            verifyElement.sendKeysWithClearNoEnter(passwordInput, "Password Input Box", Password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void enterInvalidUsernameOrPassword(String username, String password) {
        if (usernameInput.getText()!=username || passwordInput.getText()!=password)
        {
            verifyElement.verifyBrowserElement(usernameAndPasswordFieldErrorElement,"Login Errors");
            System.out.println(usernameAndPasswordFieldErrorElement.getText());
        }
    }


    public void selectDropdown(String option) {

        verifyElement.selectorOptionPicker(loginButton, "Product DropDown", option);

    }

    public void hollardBackgroundLoginElement() {

        if (backgroundImageElement.isDisplayed()) {
            System.out.println("The Background Image is Displayed");
        } else {

            Assert.fail("The Background Image is not Displayed");
        }
    }

    public void validateLoginUI() {

        if (hollardLogo.isDisplayed()) {
            System.out.println("The Hollard Logo is Displayed");
        } else {

            Assert.fail("The Hollard Logo is not Displayed");
        }
        if (forgotPasswordElement.isDisplayed()) {
            System.out.println("The Forgot Password Link is Displayed");
        } else {

            Assert.fail("The Forgot Password Link is not Displayed");
        }
        if (contactUsElement.isDisplayed()) {
            System.out.println("The Contact Us Link is Displayed");
        } else {

            Assert.fail("The Contact Us Link is not Displayed");
        }

    }
    public void validateLoginErrors() {

        if (usernameInput.getText().equals("")) {
            System.out.println(emailFieldErrorElement.getText());
        } if(passwordInput.getText().equals("")) {

            System.out.println(passwordFieldErrorElement.getText());
        }


    }
    


}


