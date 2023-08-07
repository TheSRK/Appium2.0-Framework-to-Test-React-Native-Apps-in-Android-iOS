package Tests;

import Base.BaseTest;
import DriverConfiguration.AppDriverManager;
import Pages.LoginPage;
import Utils.JSONReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static DriverConfiguration.AppDriverManager.getAppiumDriver;

public class LoginPageTests extends BaseTest {
    LoginPage loginPage;

    @BeforeMethod
    public void setLoginPage() {
        loginPage = new LoginPage(getAppiumDriver());
        JSONReader.readJSONFile();
    }

    @Test(priority = 1)
    public void updateAppTest() {
        System.out.println("driver in updateAppTest: " + getAppiumDriver());
        boolean f = loginPage.updateApp();
        Assert.assertTrue(f);
        System.out.println("driver in updateAppTest: " + getAppiumDriver());
    }

    @Test(priority = 2)
    public void loginTest() {
        Assert.assertTrue(loginPage.login(JSONReader.getEmail(), JSONReader.getPassword()));
    }

}
