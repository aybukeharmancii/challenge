package com.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(id = "twotabsearchtextbox")
    public WebElement searchInputBox;

    @FindBy(id = "nav-search-submit-button")
    public WebElement searchButton;

    @FindBy(xpath = "//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")
    public List<WebElement> allProducts;

    @FindBy(id = "productTitle")
    public WebElement productTitle;

    @FindBy(xpath = "((//div[@class='a-box-inner'])[1]//span[@class='a-price-whole'])[1]")
    public WebElement productPrice;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[1]")
    public WebElement firstProduct;

    @FindBy(xpath = "(//span[@class='a-size-base-plus a-color-base a-text-normal'])[3]")
    public WebElement thirdProduct;

    @FindBy(xpath = "(//span[@class='a-offscreen'])[1]")
    public WebElement firstProductPrice;

    @FindBy(xpath = "(//span[@class='a-offscreen'])[3]")
    public WebElement thirdProductPrice;

    @FindBy(id = "add-to-cart-button")
    public WebElement addToCart;

    @FindBy(xpath = "//*[@class='a-box a-alert-inline a-alert-inline-success sw-atc-message']")
    public WebElement toCheckIfProductIsAddedTxt;

    @FindBy(id = "nav-cart-count-container")
    public WebElement goToCart;

    @FindBy(xpath = "//span[@class='a-truncate-cut']")
    public WebElement cartProductTitle;

    @FindBy(xpath = "(//span[@class='a-truncate-cut'])[1]")
    public WebElement cartFirstProductText;

    @FindBy(xpath = "(//span[@class='a-truncate-cut'])[2]")
    public WebElement cartSecondProductText;

    @FindBy(xpath = "//p[@class='a-spacing-mini']//span")
    public WebElement cartProductPrice;

    @FindBy(xpath = "((//div[@class='sc-badge-price-to-pay'])/p/span)[1]")
    public WebElement cartFirstProductPriceText;

    @FindBy(xpath = "((//div[@class='sc-badge-price-to-pay'])/p/span)[2]")
    public WebElement cartSecondProductPriceText;

    @FindBy(xpath = "//input[@data-action='delete']")
    public WebElement deleteProductAtCart;

    @FindBy(xpath = "(//span[@class='a-button-text a-declarative'])[1]")
    public WebElement quantityOfFirstProduct;

    @FindBy(id = "quantity_2")
    public WebElement ddownQuantityOfProductIsTwo;

    @FindBy(xpath = "(//span[@class='a-dropdown-prompt'])[1]")
    public WebElement textOfQuantityOfProduct;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    public WebElement homePageAccount;

    @FindBy(id = "nav-item-signout")
    public WebElement homePageSignout;

    @FindBy(xpath = "//div[@id='nav-al-your-account']//span")
    public WebElement homePageAccountDdown;

    @FindBy(xpath = "//div[@data-card-identifier='SignInAndSecurity_T2']")
    public WebElement loginAndSecurityButton;

    @FindBy(id = "auth-cnep-edit-name-button")
    public WebElement editAccountNameButton;

    @FindBy(id = "ap_customer_name")
    public WebElement editAccountNameInput;

    @FindBy(id = "cnep_1C_submit_button")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//div[@id='auth-success-message-box']")
    public WebElement successMessageText;


}
