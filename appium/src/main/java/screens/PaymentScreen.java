package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentScreen {
    private final AndroidDriver driver;
    WebDriverWait wait;
    public PaymentScreen(AndroidDriver driver){
        this.driver = driver;
    }

    private final By fullNameTxt = AppiumBy.xpath("//android.widget.EditText[@content-desc='Full Name* input field']");
    private final By cardNumberTxt  = AppiumBy.xpath("//android.widget.EditText[@content-desc='Card Number* input field']");
    private final By expirationDateTxT = AppiumBy.xpath("//android.widget.EditText[@content-desc='Expiration Date* input field']");
    private final By securityCodeTxt = AppiumBy.xpath("//android.widget.EditText[@content-desc='Security Code* input field']");
    private final By reviewOrder = AppiumBy.xpath("//android.widget.TextView[@text='Review Order']");
    private final By assertionMessage = AppiumBy.xpath("//android.widget.TextView[@text='Review your order']");
    private final By placerOrderButton = AppiumBy.xpath("//android.widget.TextView[@text='Place Order']");
    private final By placeOrderAssertionMessage = AppiumBy.xpath("//android.widget.TextView[@text='Checkout Complete']");



    public void completePayment(String fullName, String cardNum, String expDate, String secureNum){
        driver.findElement(fullNameTxt).sendKeys(fullName);
        driver.findElement(cardNumberTxt).sendKeys(cardNum);
        driver.findElement(expirationDateTxT).sendKeys(expDate);
        driver.findElement(securityCodeTxt).sendKeys(secureNum);
    }

    public void reviewOrder(){
        driver.findElement(reviewOrder).click();
        driver.findElement(reviewOrder).click();
    }

    public String getAssertionMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }

    public void placeOrder(){
        driver.findElement(placerOrderButton).click();
    }

    public String getPlaceOrderAssertionMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(placeOrderAssertionMessage)));
        return driver.findElement(placeOrderAssertionMessage).getText();
    }

}
