package DriverConfiguration;

import ServerConfiguration.AppiumServer;
import Utils.Commons;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class AppDriverManager {
    public static AppiumDriver appiumDriver=null;
    public static void initDriver() throws MalformedURLException {
        if (appiumDriver == null){
            AppFactory.launchApp("android", appiumDriver);
        }

    }
    public static AppiumDriver getAppiumDriver(){
        return ThreadSafeDriver.getDriver();
    }

    public static void quitDriver() {
        if (appiumDriver != null){
            getAppiumDriver().quit();
            ThreadSafeDriver.unload();
        }
    }
}
