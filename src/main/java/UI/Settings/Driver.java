package UI.Settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import java.util.concurrent.TimeUnit;

public class Driver {

    static {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("mac")) {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/src/main/resources/Driver/chromedriver");
        } else {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
        }
    }

        public static WebDriver CreateChromeDriver() {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/src/main/resources/Driver/chromedriver.exe");
            return new ChromeDriver();
        }
    }

