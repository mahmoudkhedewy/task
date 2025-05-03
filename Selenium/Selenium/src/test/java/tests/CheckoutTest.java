package tests;

import data.CheckOutData;
import data.LoginData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.LoginPage;

import java.io.IOException;

public class CheckoutTest extends TestBase {
    AddToCartPage add;
    LoginPage log;
    CheckoutPage checkout;


    @Test
    public void TestLoginFunction() throws IOException, org.json.simple.parser.ParseException {
        LoginData data = new LoginData();
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.name, data.password);
        Assert.assertEquals(log.getAssertionMessage(),"Swag Labs");
    }

    @Test(priority = 1)
    public void TestAddToCart() {
        add = new AddToCartPage(driver);
        add.AddFirstProduct();
        add.AddSecondProduct();
        add.AddCart();
        Assert.assertEquals(add.getCartPageAssertionMessage(),"Your Cart");

    }

    @Test(priority = 2)
    public void AssertThatTowProductsAreInThCart() {
        add = new AddToCartPage(driver);
        Assert.assertEquals(add.getFirstProductAssertionMessage(),"Sauce Labs Backpack");
        Assert.assertEquals(add.getSecondProductAssertionMessage(),"Sauce Labs Fleece Jacket");
    }

    @Test(priority = 3)
    public void navigateToCheckoutPage()  {
        checkout = new CheckoutPage(driver);
        checkout.clickCheckoutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout"));
    }
    @Test(priority = 4)
    public void completeCheckout() throws  IOException, ParseException {
        checkout = new CheckoutPage(driver);
        CheckOutData checkOutData = new CheckOutData();
        checkOutData.UserData();
        checkout.fillUserInformation(checkOutData.firstName,checkOutData.lastName,checkOutData.ziCode);
        Assert.assertEquals(checkout.getAssertionMessage(),"Item total: $79.98");
    }

    @Test(priority = 5)
    public void Assertions(){
        checkout = new CheckoutPage(driver);
        checkout.clickFinishButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-step-two.html");
        Assert.assertEquals(checkout.getThanksAssertionMessage(),"THANK YOU FOR YOUR ORDER");
        Assert.assertTrue(checkout.getGetDispatchedMessage().contains("Your order has been dispatched"));
    }

}
