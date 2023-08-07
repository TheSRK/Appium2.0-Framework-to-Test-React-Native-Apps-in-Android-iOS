package Utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class Commons {
    public static boolean tap(AppiumDriver driver, WebElement element){
        Point location = element.getLocation();
        Dimension size = element.getSize();

        Point centerOfElement = getCenterOfElement(location, size);

        PointerInput thumbFinger= new PointerInput(PointerInput.Kind.TOUCH,"thumbFinger");

        Sequence sequence = new Sequence(thumbFinger,1)
                .addAction(thumbFinger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(),centerOfElement))
                .addAction(thumbFinger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(new Pause(thumbFinger,Duration.ofMillis(200)))
                .addAction(thumbFinger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
        return true;
    }
    public static Point getCenterOfElement(Point location, Dimension size){
        return new Point(location.getX()+ size.getWidth()/2, location.getY()+size.getHeight()/2);
    }
    public static boolean sendKeys(WebElement element, String text){
        element.sendKeys(text);
        return true;
    }

    public static WebElement explicitWait(AppiumDriver driver, WebElement element, int timeOutInSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public static void quitDriver(AppiumDriver driver){
            driver.quit();
    }
}
