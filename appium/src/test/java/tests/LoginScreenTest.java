package tests;

import data.LoginData;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.HomePage;
import screens.LoginScreen;

import java.io.IOException;

public class LoginScreenTest extends TestBase{
    HomePage homePage;
    LoginScreen loginScreen;

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
}
