package Base;

import DriverConfiguration.AppDriverManager;
import DriverConfiguration.ThreadSafeDriver;
import ServerConfiguration.AppiumServer;
import Utils.Commons;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

public class BaseTest {
   @BeforeTest
    public static void setup() throws MalformedURLException {
        //AppiumServer.start();
        AppDriverManager.initDriver();
       System.out.println("driver value in setup method: "+AppDriverManager.getAppiumDriver());
    }


//    @Test
//    public void androidLaunchTest() {
//        System.out.println("android launch method thread id: "+Thread.currentThread().getId());
//
//        appiumDriver.findElement(AppiumBy.accessibilityId("open menu")).click();
////        new WebDriverWait(appiumDriver, Duration.ofSeconds(10))
////               .until(e->e.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")));
//        appiumDriver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item log in\"]")).click();
//        //Thread.sleep(5000);
//        appiumDriver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("username");
//        appiumDriver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("123456");
//        appiumDriver.findElement(AppiumBy.accessibilityId("Login button")).click();
//
//
//    }
//@Test
//    public void tapTest() throws InterruptedException, MalformedURLException {
//        AppiumServer.start();
//        //AppDriverManager.initDriver();
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName("emulator-5554");
//        options.setApp(System.getProperty("user.dir")+"/apps/androidRespond.apk");
//        options.fullReset();
//        System.out.println("android launch method 1 : "+appiumDriver);
//        //appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
//        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
//        System.out.println("android launch method 2: "+appiumDriver);
//
//        WebElement btnDownloadUpdate=  driver.findElement(AppiumBy.id("android:id/button1"));
//        if (btnDownloadUpdate.isEnabled() && btnDownloadUpdate.isDisplayed()){
//            Commons.tap(  driver,btnDownloadUpdate);
//
//            WebElement btnResetButton= driver.findElement(AppiumBy.xpath("//*[@resource-id=\"android:id/button1\"][@text=\"RESTART APP\"]"));
//            Commons.explicitWait( driver,btnResetButton,30);
//
//            if (btnResetButton.isEnabled() && btnResetButton.isDisplayed()){
//                Commons.tap(  driver,btnResetButton);
//            }
//        }
//
//        System.out.println(" *****tap performed*******");
//        System.out.println("tap method thread id: "+Thread.currentThread().getId());
//        driver.quit();
//        AppiumServer.stop();
//    }





//    @Test
//    public void iosLaunchTest() throws MalformedURLException, InterruptedException {
//        XCUITestOptions options = new XCUITestOptions();
//        options.setDeviceName("iPhone SE (3rd generation)");
//        options.setApp(System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");
//
//        IOSDriver appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
////        AppDriverFactory.setDriver("ios");
////        appiumDriver = AppDriverFactory.getDriver();
//
//    }

  @AfterTest
    public void tearDown() {
      System.out.println("driver value before quit: "+AppDriverManager.getAppiumDriver());
        AppDriverManager.getAppiumDriver().quit();
      System.out.println("driver value after quit: "+AppDriverManager.getAppiumDriver());
        //AppiumServer.stop();
    }
}
