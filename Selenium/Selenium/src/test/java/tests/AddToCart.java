package tests;

import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.CheckoutPage;
import pages.LoginPage;

import java.io.IOException;
public class AddToCart extends TestBase{
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
    public void TestAddToCart()  {
        add = new AddToCartPage(driver);
        add.AddFirstProduct();
        add.AddSecondProduct();
        add.AddCart();
        Assert.assertEquals(add.getCartPageAssertionMessage(),"Your Cart");

    }

    @Test(priority = 2)
    public void AssertThatTowProductsAreInThCart()  {
        add = new AddToCartPage(driver);

        Assert.assertEquals(add.getFirstProductAssertionMessage(),"Sauce Labs Backpack");
        Assert.assertEquals(add.getSecondProductAssertionMessage(),"Sauce Labs Fleece Jacket");
        checkout = new CheckoutPage(driver);
        checkout.clickCheckoutButton();
    }


}
