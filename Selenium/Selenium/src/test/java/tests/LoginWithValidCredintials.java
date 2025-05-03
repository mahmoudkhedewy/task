package tests;


import data.LoginData;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;


public class LoginWithValidCredintials extends TestBase {
    LoginPage log;


    @Test
    public void TestLoginFunction() throws IOException,  org.json.simple.parser.ParseException {
        LoginData data = new LoginData();
        data.UserData();
        log = new LoginPage(driver);
        log.Login(data.name, data.password);
        Assert.assertEquals(log.getAssertionMessage(),"Swag Labs");
    }


}
