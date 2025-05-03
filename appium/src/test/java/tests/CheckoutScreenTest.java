package tests;

import data.CheckoutData;
import data.LoginData;
import data.PaymentData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.*;

import java.io.IOException;

public class CheckoutScreenTest extends TestBase{
    HomePage homePage;
    LoginScreen loginScreen;
    AddToCartScreen add;
    CheckOutScreen check;
    PaymentScreen paymentScreen;

    @Test
    public void navigateToRegisterPage() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.navigateToLoginScreen();
    }
    @Test(priority = 1)
    public void enterRegisterData() throws IOException, ParseException, InterruptedException {
        LoginData data = new LoginData();
        data.testData();
        loginScreen = new LoginScreen(driver);
        loginScreen.enterRegisterData(data.email, data.password);
        loginScreen.enterLoginButton();
        Assert.assertEquals(loginScreen.getAssertionMessage(),"Products");
    }

    @Test(priority = 2)
    public void addProductToCart(){
        add = new AddToCartScreen(driver);
        add.addToCart();
        add.navigateToCartDetails();
        Assert.assertEquals(add.getAssertionMessage(),"Sauce Labs Bolt T-Shirt");
    }
    @Test(priority = 3)
    public void navigateToCartDetails(){
        add = new AddToCartScreen(driver);
        add.navigateToCartDetails();
    }

    @Test(priority = 4)
    public void navigateToCheckoutScreen() throws InterruptedException {
        check = new CheckOutScreen(driver);
        check.navigateToCheckoutScreen();
    }
    @Test(priority = 5)
    public void completeCheckout() throws IOException, ParseException {
        CheckoutData data = new CheckoutData();
        data.testData();
        check = new CheckOutScreen(driver);
        check.enterCheckoutData(data.fullName, data.addressOne, data.addressTow, data.city, data.state, data.zipcode, data.country);
        check.navigateToPaymentScreen();
        Assert.assertEquals(check.getCheckoutAssertionMessage(),"Enter a payment method");
    }

    @Test(priority = 6)
    public void completePayment() throws IOException, ParseException, InterruptedException {
        PaymentData data = new PaymentData();
        data.testData();
        paymentScreen = new PaymentScreen(driver);
        paymentScreen.completePayment(data.fullName, data.cardNumber, data.expDate, data.secNumber);
        paymentScreen.reviewOrder();
        Assert.assertEquals(paymentScreen.getAssertionMessage(),"Review your order");
        paymentScreen.placeOrder();
        Assert.assertEquals(paymentScreen.getPlaceOrderAssertionMessage(),"Checkout Complete");

    }

}
