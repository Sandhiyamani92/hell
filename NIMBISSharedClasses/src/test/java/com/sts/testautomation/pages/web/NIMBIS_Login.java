package com.sts.testautomation.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sts.testautomation.utilities.ElementFunctionality;
public class NIMBIS_Login {

    public WebDriver BrowserDriver;
    public ElementFunctionality verifyElement;
    public String Device;

    public  NIMBIS_Login(WebDriver browserDriver, String Device)
    {
        BrowserDriver = browserDriver;
        this.Device=Device; verifyElement = new ElementFunctionality(BrowserDriver, Device);
        PageFactory.initElements(BrowserDriver, this);
    }

    @FindBy(xpath = "//input[@id='ContentLogin_ucLoginForm_LoginUser_UserName']")
    private WebElement UserName_Txt ;

    @FindBy(xpath = "//input[@id='ContentLogin_ucLoginForm_LoginUser_btnGetAuthType']")
    private WebElement continueBtn ;

    @FindBy(xpath = "//input[@id='ContentLogin_ucLoginForm_LoginUser_Password']")
    private WebElement Password_Txt ;

    @FindBy(xpath = "//input[@id='ContentLogin_ucLoginForm_LoginUser_btnLogin']")
    private WebElement SignInBtn ;


    public void enterUsername(String username) {

        if (verifyElement.verifyBrowserElementValue(UserName_Txt, "Username") == 0) {
            verifyElement.sendKeys(UserName_Txt, "Username", username);
        }
    }
    public void enterPassword(String password) {

        if (verifyElement.verifyBrowserElementValue(Password_Txt, "Password") == 0) {
            verifyElement.sendKeys(Password_Txt, "Password", password);
        }
    }

    public void clickContinueBtn() {

        if (verifyElement.verifyBrowserElementValue(UserName_Txt, "Continue Button") == 0) {
            verifyElement.clickElement(continueBtn,"Continue Button");
        }
    }
    public void clickSignInBtn() {

        if (verifyElement.verifyBrowserElementValue(SignInBtn, "Sign In  Button") == 0) {
            verifyElement.clickElement(SignInBtn,"Sign In Button");
        }
    }


}
