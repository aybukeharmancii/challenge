package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "sp-cc-accept")
    public WebElement homePageAcceptCookies;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement homePageLoginButton;

    @FindBy(id = "ap_email")
    public WebElement email;

    @FindBy(id = "continue")
    public WebElement loginContinueButton;

    @FindBy(id = "ap_password")
    public WebElement password;

    @FindBy(id = "signInSubmit")
    public WebElement loginButton;


}
