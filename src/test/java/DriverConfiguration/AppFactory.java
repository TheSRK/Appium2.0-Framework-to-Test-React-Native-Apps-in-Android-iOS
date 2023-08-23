package DriverConfiguration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class AppFactory {
    public static void launchApp(String platformName, AppiumDriver appiumDriver) throws MalformedURLException {

        if (platformName.equalsIgnoreCase("Android")){
            UiAutomator2Options options = new UiAutomator2Options();
            //options.setDeviceName("Pixel_3a_API_34_extension_level_7_arm64-v8a");
            options.setDeviceName("emulator-5554");
            options.setApp(System.getProperty("user.dir")+"/apps/androidRespond.apk");
            options.fullReset();

            appiumDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
            ThreadSafeDriver.setDriver(appiumDriver);

        } else if (platformName.equalsIgnoreCase("iOS")) {
            XCUITestOptions options = new XCUITestOptions();
            options.setDeviceName("iPhone SE (3rd generation)");
            options.setApp(System.getProperty("user.dir")+"/apps/iOS-Simulator-MyRNDemoApp.1.3.0-162.zip");

            appiumDriver = new IOSDriver(new URL("http://127.0.0.1:4723"),options);
            ThreadSafeDriver.setDriver(appiumDriver);

        }

    }


}
