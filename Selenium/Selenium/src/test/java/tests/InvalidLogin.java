package tests;

import data.InvalidLoginData;
import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;
import java.text.ParseException;

public class InvalidLogin extends TestBase {
    LoginPage log;

    @Test
    public void TestLoginFunction() throws IOException,  org.json.simple.parser.ParseException {
        InvalidLoginData data = new InvalidLoginData();
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.name, data.password);
        Assert.assertEquals(log.getInvalidLoginAssertionMessage(),
                "Epic sadface: Username and password do not match any user in this service");
    }
}
