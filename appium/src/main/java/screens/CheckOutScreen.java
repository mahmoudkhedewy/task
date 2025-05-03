package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckOutScreen {
    private final AndroidDriver driver;
    WebDriverWait wait;
    public CheckOutScreen(AndroidDriver driver){
        this.driver = driver;
    }

    private final By checkoutButton = AppiumBy.xpath("//android.widget.TextView[@text='Proceed To Checkout']");
    private final By fullNameTxt = AppiumBy.xpath("//android.widget.EditText[@text='Rebecca Winter']");
    private final By addressOneTxt = AppiumBy.xpath("//android.widget.EditText[@text='Mandorley 112']");
    private final By addressTowTxt = AppiumBy.xpath("//android.widget.EditText[@text='Entrance 1']");
    private final By cityTxt = AppiumBy.xpath("//android.widget.EditText[@text='Truro']");
    private final By stateTxt = AppiumBy.xpath("//android.widget.EditText[@text='Cornwall']");
    private final By zipCodeTxt = AppiumBy.xpath("//android.widget.EditText[@content-desc='Zip Code* input field']");
    private final By countryTxt = AppiumBy.xpath("//android.widget.EditText[@content-desc='Country* input field']");
    private final By toPayment = AppiumBy.xpath("//android.widget.TextView[@text='To Payment']");
    private final By checkOutAssertionMessage = AppiumBy.xpath("//android.widget.TextView[@text='Enter a payment method']");

    public void navigateToCheckoutScreen() throws InterruptedException {
        driver.findElement(checkoutButton).click();
    }

    public void enterCheckoutData(String fullName, String addressOne, String addressTow, String city, String state,
                                  String zipcode, String country){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(fullNameTxt)));
        driver.findElement(fullNameTxt).sendKeys(fullName);
        driver.findElement(addressOneTxt).sendKeys(addressOne);
        driver.findElement(addressTowTxt).sendKeys(addressTow);
        driver.findElement(cityTxt).sendKeys(city);
        driver.findElement(stateTxt).sendKeys(state);
        driver.findElement(zipCodeTxt).sendKeys(zipcode);
        driver.findElement(countryTxt).sendKeys(country);
    }

    public void navigateToPaymentScreen(){
        driver.findElement(toPayment).click();
    }

    public String getCheckoutAssertionMessage(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(checkOutAssertionMessage)));
        return driver.findElement(checkOutAssertionMessage).getText();
    }
}

