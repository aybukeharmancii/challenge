package com.test.helper;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
@Slf4j
public class BrowserHelper {
    private BrowserHelper() {

    }

    private static Map<String, String> savedTexts = new HashMap<>();

    public static WebElement waitForVisibility(WebElement element, int timeOut) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOut);
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (org.openqa.selenium.TimeoutException e) {
            log.info("Wait has been exceeded the expected period.");
        }
        return element;
    }

    private static void scrollDownToElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.get();
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void clickElement(WebElement element) {
        int timeOut = Integer.parseInt(ConfigReader.get("timeOut"));
        try {
            waitForVisibility(element, timeOut);
            element.click();
        } catch (org.openqa.selenium.ElementNotVisibleException e) {
            scrollDownToElement(element);
            waitForVisibility(element, timeOut);
            element.click();
        }
    }

    public static void sendKeys(WebElement element, String key) {
        int timeOut = Integer.parseInt(ConfigReader.get("timeOut"));
        try {
            waitForVisibility(element, timeOut);
            element.clear();
            element.sendKeys(key);
        } catch (org.openqa.selenium.ElementNotVisibleException e) {
            scrollDownToElement(element);
            waitForVisibility(element, timeOut);
            element.clear();
            element.sendKeys(key);
        }

    }

    public static void saveTextForKey(String key, String text) {
        savedTexts.put(key, text);
    }

    public static String retrieveTextForKey(String key) {
        return savedTexts.get(key);
    }

    public static List<String> getElementsText(By locator) {

        List<WebElement> elems = Driver.get().findElements(locator);
        List<String> elemTexts = new ArrayList<>();

        for (WebElement el : elems) {
            waitForVisibility(el, 10);
            elemTexts.add(el.getText());
        }
        return elemTexts;
    }

    public static String getElementText(WebElement element) {
        String text = null;
        int timeOut = Integer.parseInt(ConfigReader.get("timeOut"));
        try {
            waitForVisibility(element, timeOut);
            text = element.getText();
        } catch (Exception e) {
            return null;
        }
        return text;
    }

    public static void navigateBack() {
        Driver.get().navigate().back();
    }

    public static int timeout() {
        int timeOut = Integer.parseInt(ConfigReader.get("timeOut"));
        return timeOut;
    }

    public static void clickPlaceElement(List<WebElement> elements, int place) {
        WebElement el = elements.get(place - 1);
        waitForVisibility(el, timeout());
        el.click();

    }

    public static boolean checkElementExists(WebElement elementLocator) {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeout());
            wait.until(ExpectedConditions.visibilityOf(elementLocator));
            return true;
        } catch (org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public static void CheckElementTextIsSame(WebElement expectedElement, WebElement actualElement) {
        Assert.assertTrue(expectedElement.getText().contains(actualElement.getText()));

    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) Driver.get()).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.get(), timeout());
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static void navigateToUrl(String url) {
        Driver.get().get(url);
    }

    public static void asLongAsElementExistsClick(WebElement elementLocator) {
        try {
            while (elementLocator != null) {
                clickElement(elementLocator);
            }
        } catch (org.openqa.selenium.NoSuchElementException e) {
        }

    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void hover(WebElement elementLocator) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(elementLocator).perform();
    }

    public static String randomNumber() {
        Random rn = new Random();
        int i = rn.nextInt(55);
        String number = String.valueOf(i);
        return number;

    }

}
