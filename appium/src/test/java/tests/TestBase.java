package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class TestBase {
    protected AndroidDriver driver;
    UiAutomator2Options caps;
    AppiumDriverLocalService localService;

    @BeforeSuite
    public void runServer(){
        localService = AppiumDriverLocalService.buildDefaultService();
        localService = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\CompuMisr\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("0.0.0.0")
                .withTimeout(Duration.ofSeconds(90))
                .usingPort(4723)
                .build();
        localService.start();

    }
    @BeforeClass
    public void setDriver() throws URISyntaxException, MalformedURLException {
        caps = new UiAutomator2Options();
        caps.
                setDeviceName(System.getProperty("deviceName"))
                .setPlatformName(System.getProperty("platformName"))
                .setPlatformVersion(System.getProperty("PlatformVersion"))
                .setApp(System.getProperty("user.dir")+"/src/test/resources/app/Android-MyDemoAppRN.1.3.0.build-244.apk");
        driver = new AndroidDriver(new URI("http://0.0.0.0:4723").toURL(),caps);
    }
    
    @AfterClass
    public void quitDriver(){
        driver.quit();
    }

    @AfterSuite
    public void stopService(){
        localService.stop();
    }
}
