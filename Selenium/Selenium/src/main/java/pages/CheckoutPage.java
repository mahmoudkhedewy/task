package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CheckoutPage {
    private final WebDriver driver;
    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    private final By checkoutBtn = By.id("checkout");
    private final By firstNameTxt = By.id("first-name");
    private final By lastNameTxt = By.id("last-name");
    private final By zipCodeTxt = By.id("postal-code");
    private final By continueBtn = By.id("continue");
    private final By assertionMessage = By.xpath("//div[text()='79.98']");
    private final By finishOrder = By.id("finish");
    private final By thanksAssertionMessage = By.xpath("//h2[text()='THANK YOU FOR YOUR ORDER']");
    private final By getDispatchedMessage = By.xpath("//div[@class='complete-text']");


    public void clickCheckoutButton(){

        driver.findElement(checkoutBtn).click();
    }
    public void fillUserInformation(String firstname, String lastName, String zipCode){
        driver.findElement(firstNameTxt).sendKeys(firstname);
        driver.findElement(lastNameTxt).sendKeys(lastName);
        driver.findElement(zipCodeTxt).sendKeys(zipCode);
        driver.findElement(continueBtn).click();
    }

    public String getAssertionMessage(){
        return  driver.findElement(assertionMessage).getText();
    }
    public void clickFinishButton(){
        driver.findElement(finishOrder).click();
    }

    public String getThanksAssertionMessage(){
        return driver.findElement(thanksAssertionMessage).getText();
    }

    public String getGetDispatchedMessage(){
        return driver.findElement(getDispatchedMessage).getText();
    }



}
