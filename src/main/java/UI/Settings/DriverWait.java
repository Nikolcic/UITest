package UI.Settings;

import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class DriverWait {

    public static WebDriverWait generateWaits (WebDriver driver, int iWait, int eWait){
        driver.manage().timeouts().implicitlyWait(iWait, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, eWait);
        wait.ignoring(NoSuchElementException.class);
        wait.ignoring(Exception.class);
        wait.ignoring(WebDriverException.class);
        wait.ignoring(ElementClickInterceptedException.class);
        wait.ignoring(StaleElementReferenceException.class);
        return wait;
    }
}
