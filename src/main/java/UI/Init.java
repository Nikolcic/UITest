package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

public class Init {

    public static WebDriver CreateChromeDriver(){
        System.setProperty(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY, System.getProperty("user.dir") + "/src/main/resources/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        return  driver;
    }
}
