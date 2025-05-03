package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage {
    private final WebDriver driver;
    WebDriverWait wait;
    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By firstProduct = By.id("add-to-cart-sauce-labs-backpack");
    private final By secondProduct = By.id("add-to-cart-sauce-labs-fleece-jacket");
    private final By cartButton = By.xpath("//a[@class='shopping_cart_link']");
    private final By cartPageAssertionMessage = By.xpath("//span[text()='Your Cart']");
    private final By firstProductAssertion = By.xpath("//div[text()='Sauce Labs Backpack']");
    private final By secondProductAssertion = By.xpath("//div[text()='Sauce Labs Fleece Jacket']");


    public void AddFirstProduct() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(firstProduct)));
        driver.findElement(firstProduct).click();
    }
    public void AddSecondProduct()  {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(secondProduct)));
        driver.findElement(secondProduct).click();
    }

    public void AddCart() {
        driver.findElement(cartButton).click();
    }

    public String getCartPageAssertionMessage() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartPageAssertionMessage));
        return driver.findElement(cartPageAssertionMessage).getText();

    }

    public String getFirstProductAssertionMessage() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstProductAssertion));
        return driver.findElement(firstProduct).getText();
    }

    public String getSecondProductAssertionMessage() {
        wait = new WebDriverWait(driver,Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(secondProductAssertion));
        return driver.findElement(secondProduct).getText();
    }
}
