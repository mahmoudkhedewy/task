package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private final By userNameTxt = By.id("user-name");
    private final By passwordTxt = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By assertionMessage = By.xpath("//div[@class='app_logo']");
    private final By errorMessage = By.xpath("//h3[@data-test='error']");

    public void Login(String name, String password){
        driver.findElement(userNameTxt).sendKeys(name);
        driver.findElement(passwordTxt).sendKeys(password);
        if (driver.findElement(loginBtn).isEnabled()){
            driver.findElement(loginBtn).click();
        }

        else {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(loginBtn)));
            driver.findElement(loginBtn).click();
        }
    }

    public String getAssertionMessage(){
        return  driver.findElement(assertionMessage).getText();
    }

    public String getInvalidLoginAssertionMessage(){
        return driver.findElement(errorMessage).getText();
    }
}
