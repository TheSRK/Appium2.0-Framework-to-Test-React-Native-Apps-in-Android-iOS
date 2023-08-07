package DriverConfiguration;

import io.appium.java_client.AppiumDriver;
public class ThreadSafeDriver {
    //Generate ThreadLocal Driver
    private static final ThreadLocal<AppiumDriver> threadLocalDriver = new ThreadLocal<>();

//Set Driver
    public static void setDriver(AppiumDriver appiumDriver){
        threadLocalDriver.set(appiumDriver);
        System.out.println("*******Driver is set*******");
    }

//Get Driver
    public static AppiumDriver getDriver(){
        return threadLocalDriver.get();
    }

//Unload Driver
    public static void unload(){
        threadLocalDriver.remove();
        System.out.println("*******Driver is unloaded*******");
    }
}
