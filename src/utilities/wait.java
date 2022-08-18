package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class wait
{
    public static WebDriver driver;
    public static Duration timeout = Duration.ofSeconds(10);
    public static WebDriverWait Wait = new WebDriverWait(driver, timeout);


    public static void seconds(double seconds)
    {
        Wait.withTimeout(Duration.ofSeconds((long)seconds));
    }

    public static void untilElementNotFound(By by)
    {
        Wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void  untilVisibleAndEnabled(By by)
    {
        Wait.until(ExpectedConditions.elementToBeClickable(by));
    }

}