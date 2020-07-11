package UI;

import UI.Settings.Vars;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;
import static  org.testng.Assert.*;


public class Helper {

    public Helper(WebDriver driver, WebDriverWait wait, WebElements elements){
        this.driver = driver;
        this.wait = wait;
        this.elements = elements;
    }

    public WebDriver driver;
    public WebDriverWait wait;
    public WebElements elements;



    public static void NavigateToURL(WebDriver driver, String url){
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.navigate().to(url);
    }

    public static  String generateFileName() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.getMinute() + "." + dateTime.getSecond() +".png";
    }

    public void makePause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public WebElement waitForVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void hoverOverElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public WebElement clickWhenReady(WebElement element) {
        makePause(Vars.SHORTER_SLEEP);
        waitForVisible(element);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    public void assertElementPresent(WebElement element) {
        assertTrue(element.isDisplayed(), element.getTagName()+" element is not displayed");
    }

    public boolean isElementPresent(By element) {
        boolean bool;
        bool = !driver.findElements(element).isEmpty();
        return bool;
    }

    public void moveToElemet(WebElement from, WebElement to){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(from, to);
        actions.build().perform();
    }

    public String generateShortName(String base) {
        return base + "_" + LocalDateTime.now().getMinute() + "_" + LocalDateTime.now().getSecond();
    }
}
