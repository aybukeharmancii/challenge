package com.test.step_def;

import com.test.pages.LoginPage;
import com.test.pages.ProductPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;

import static com.test.helper.BrowserHelper.*;

@Slf4j
public class Product_stepdef {
    ProductPage productPage = new ProductPage();
    LoginPage loginPage = new LoginPage();


    @And("User searchs {string}")
    public void userSearchsText(String text) {
        sendKeys(productPage.searchInputBox, text);
        clickElement(productPage.searchButton);
    }


    @Given("User adds {int}. product to basket and checks correct product and price is correct")
    public void user_adds_product_to_basket_and_checks_correct_product_and_price_is_correct(int place) {
        clickPlaceElement(productPage.allProducts, place);
        String productTitle = getElementText(productPage.productTitle);
        log.info("productTitle = " + productTitle);
        String productPrice = getElementText(productPage.productPrice);
        log.info("productPrice = " + productPrice);
        clickElement(productPage.addToCart);
        clickElement(productPage.goToCart);
        waitFor(2);
        String beforeTrim = getElementText(productPage.cartProductTitle);
        int lenBeforeTrim = beforeTrim.length();
        String ActualProductTitle = beforeTrim.substring(0, lenBeforeTrim - 4);
        log.info("ActualProductTitle = " + ActualProductTitle);
        String ActualProductPrice = getElementText(productPage.cartProductPrice);
        log.info("ActualProductPrice = " + ActualProductPrice);
        Assert.assertTrue(ActualProductPrice.contains(productPrice));
        Assert.assertTrue(productTitle.contains(ActualProductTitle));
    }

    @Given("Go back {int} times")
    public void go_back_times(int times) {
        for (int i = 0; i < times; i++)
            waitForPageToLoad(timeout());
        navigateBack();
    }

    @Given("Wait for page to load")
    public void wait_for_page_to_load() {
        waitForPageToLoad(timeout());
    }

    @And("Empty the shopping cart")
    public void empty_the_cart() {
        clickElement(productPage.goToCart);
        asLongAsElementExistsClick(productPage.deleteProductAtCart);
        navigateToUrl("https://www.amazon.com.tr/");
    }

    @And("Go to laptop search results")
    public void go_to_laptop_search_results() {
        navigateToUrl("https://www.amazon.com.tr/s?k=laptop");
    }

    @When("The quantity of the first item in the cart is increased by one")
    public void increase_quantity_by_one() {
        clickElement(productPage.quantityOfFirstProduct);
        clickElement(productPage.ddownQuantityOfProductIsTwo);
    }

    @Then("Check that the quantity of the first item in the cart is increased by one")
    public void check_if_quantity_is_increased_by_one() {
        String expectedText = "2";
        waitFor(5);
        String quantityOfProduct = getElementText(productPage.textOfQuantityOfProduct);
        Assert.assertEquals(expectedText, quantityOfProduct);
    }

    @And("Signout")
    public void signout() {
        try {
            hover(productPage.homePageAccount);
            clickElement(productPage.homePageSignout);
        } catch (org.openqa.selenium.json.JsonException e) {
        }
        waitForVisibility(loginPage.loginContinueButton, timeout());
        checkElementExists(loginPage.loginContinueButton);
    }

    @And("Go to home page")
    public void go_to_home_page() {
        hover(productPage.homePageAccount);
        clickElement(productPage.homePageSignout);
    }

    @And("Hover on account on home page and click account")
    public void hover_on_account_and_click_account() {
        hover(productPage.homePageAccount);
        clickElement(productPage.homePageAccountDdown);
    }

    @When("Change account name")
    public void change_account_name() {
        clickElement(productPage.loginAndSecurityButton);
        clickElement(productPage.editAccountNameButton);
        String accountName = "TestAutomation" + randomNumber();
        sendKeys(productPage.editAccountNameInput, accountName);
    }

    @Then("Save account name changes")
    public void save_account_name_change() {
        clickElement(productPage.saveChangesButton);
        waitForVisibility(productPage.successMessageText, timeout());
        checkElementExists(productPage.successMessageText);
    }
}
