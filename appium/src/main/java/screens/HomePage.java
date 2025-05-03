package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final AndroidDriver driver;
    WebDriverWait wait;
    public HomePage(AndroidDriver driver){
        this.driver = driver;
    }

    private final By signInButton = AppiumBy.xpath("//android.widget.ImageView[@bounds='[55,101][124,170]']");
    private final By loginButton = AppiumBy.xpath("//android.widget.TextView[@text='Log In']");

    public LoginScreen navigateToLoginScreen() throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(signInButton)));
        driver.findElement(signInButton).click();
        Thread.sleep(2000); //not best practices
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }
}
