package screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UpdateCartScreen {
    private final AndroidDriver driver;
    WebDriverWait wait;
    public UpdateCartScreen(AndroidDriver driver){
        this.driver = driver;
    }

    private final By addButton = AppiumBy.xpath("//android.widget.ImageView[@bounds='[275,874][385,984]']");
    private final By addAssertion = AppiumBy.xpath("//android.widget.TextView[@bounds='[232,1754][378,1813]']");
    private final By removeButton = AppiumBy.xpath("//android.widget.TextView[@text='Remove Item']");
    private final By removeAssertion = By.xpath("//android.widget.TextView[@text='No Items']");

    public void addOneMoreProduct(){
        driver.findElement(addButton).click();
    }

    public String getAddAssertionMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElement(addAssertion).getText();
    }

    public void removeItems(){
        driver.findElement(removeButton).click();
    }

    public String getRemoveItemAssertion(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(removeAssertion)));
        return driver.findElement(removeAssertion).getText();
    }
}
