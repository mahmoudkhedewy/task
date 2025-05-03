package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginScreen {
    WebDriverWait wait;
    private final AndroidDriver driver;
    public LoginScreen(AndroidDriver driver){
        this.driver = driver;
    }

    private final By emailTxt = AppiumBy.xpath("//android.widget.EditText[@content-desc='Username input field']");
    private final By passwordTxt = AppiumBy.xpath("//android.widget.EditText[@content-desc='Password input field']");
    private final By loginButton = AppiumBy.xpath("//android.widget.TextView[@bounds='[476,1404][605,1460]']");
    private final By assertionMessage = AppiumBy.xpath("//android.widget.TextView[@text='Products']");


    public void enterRegisterData( String email, String password) throws InterruptedException {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(emailTxt)));
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
    }

    public void enterLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginButton)));
        driver.findElement(loginButton).click();
    }

    public String getAssertionMessage() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(assertionMessage)));
        return driver.findElement(assertionMessage).getText();
    }

}
