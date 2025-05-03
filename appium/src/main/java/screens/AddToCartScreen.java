package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartScreen {
    private final AndroidDriver driver;
    WebDriverWait wait;
    public AddToCartScreen(AndroidDriver driver){
        this.driver = driver;
    }

    private final By product = AppiumBy.xpath("//android.widget.TextView[@text='Sauce Labs Bolt T-Shirt']");
    private final By addToCartButton = AppiumBy.xpath("//android.widget.TextView[@text='Add To Cart']");
    private final By cartIcon = AppiumBy.xpath("//android.widget.TextView[@text='1']");
    private final By assertionMessage = AppiumBy.xpath("//android.widget.TextView[@text='Sauce Labs Bolt T-Shirt']");


    public void addToCart(){
        driver.findElement(product).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(addToCartButton).click();
    }

    public void navigateToCartDetails(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartIcon)));
        driver.findElement(cartIcon).click();
    }

    public String getAssertionMessage(){
        return driver.findElement(assertionMessage).getText();
    }

}
