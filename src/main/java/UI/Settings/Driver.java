package UI.Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Driver {

    static {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac"))
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/src/main/resources/Driver/chromedriver");
        else
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
    }

    public static WebDriver CreateChromeDriver() {
        return new ChromeDriver();
    }

    public static WebDriverWait generateWaits(WebDriver driver, int iWait, int eWait) {
        driver.manage().timeouts().implicitlyWait(iWait, TimeUnit.SECONDS);
        return new WebDriverWait(driver, eWait);
    }
}

