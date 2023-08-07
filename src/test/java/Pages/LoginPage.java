package Pages;

import Utils.Commons;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import static Utils.Commons.*;


public class LoginPage {
    @AndroidFindBy(id = "android:id/button1")
    public WebElement btnDownloadUpdate;
    @AndroidFindBy(id = "android:id/button1")
    public WebElement btnRestartApp;
    @AndroidFindBy(id="android:id/alertTitle")
    public WebElement alertSuccess;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Email address\"]")
    public WebElement txtEmail;
    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Password\"]")
    public WebElement txtPassword;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign In\"]")
    public WebElement btnSignIn;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Reset Password\"]")
    public WebElement btnResetPassword;

    AppiumDriver appiumDriver;

    public LoginPage(AppiumDriver driver) {
        this.appiumDriver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
    }

    public void tapDownloadUpdate(){
        tap( appiumDriver, explicitWait(appiumDriver,btnDownloadUpdate,20));
    }
    public void tapRestartApp(){
        tap( appiumDriver, explicitWait(appiumDriver,btnRestartApp,120));
    }
    public void tapSignIn(){
        tap( appiumDriver, explicitWait(appiumDriver,btnSignIn,20));
    }
    public void tapResetPassword(){
        tap( appiumDriver, btnResetPassword);
    }
    public void enterEmail(String email){
        explicitWait(appiumDriver,txtEmail,20);
        sendKeys(txtEmail,email);
    }

    public void enterPassword(String password){
        explicitWait(appiumDriver,txtPassword,20);
        sendKeys(txtPassword,password);
    }

    public boolean login(String email, String password){
        enterEmail(email);
        enterPassword(password);
        tapSignIn();
        return true;
    }

    public boolean updateApp(){
        tapDownloadUpdate();
        tapRestartApp();
        return true;
    }
}
