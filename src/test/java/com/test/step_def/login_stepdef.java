package com.test.step_def;

import com.test.helper.Driver;
import com.test.pages.LoginPage;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static com.test.helper.BrowserHelper.clickElement;
import static com.test.helper.BrowserHelper.sendKeys;

@Slf4j
public class login_stepdef {
    LoginPage loginPage = new LoginPage();

    @Given("User logs in with {string} email and {string} password.")
    public void user_logs_in_with_email_and_password(String email, String password) throws InterruptedException {
        clickElement(loginPage.homePageAcceptCookies);
        clickElement(loginPage.homePageLoginButton);
        sendKeys(loginPage.email, email);
        clickElement(loginPage.loginContinueButton);
        sendKeys(loginPage.password, password);
        clickElement(loginPage.loginButton);
        Assert.assertEquals("https://www.amazon.com.tr/ap/signin", Driver.get().getCurrentUrl());
        log.info("ExampleAllLogin");
    }
}
