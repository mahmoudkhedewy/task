package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestBase {
    protected WebDriver driver;
    Properties properties;


    @BeforeClass
    @Parameters({"browser"})
    public void setDriver(@Optional("firefox") String browserName) throws IOException {
        properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/config.properties");
        properties.load(fis);

        if (browserName.equalsIgnoreCase(properties.getProperty("firefoxBrowser"))){
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
            driver.navigate().to(properties.getProperty("url"));
        }
        else if (browserName.equalsIgnoreCase(properties.getProperty("chromeBrowser"))){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to(properties.getProperty("url"));
        }
    }

    @AfterClass
    public void closeDriver(){
        driver.close();
    }
}
