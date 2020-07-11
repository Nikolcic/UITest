package UI;

import UI.Settings.Vars;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.touch.TouchActions;
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

    public void dragAndDropElement(WebElement element, WebElement destination){
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element, destination).build().perform();

        /*String xto=Integer.toString(element.getLocation().x);
        String yto=Integer.toString(element.getLocation().y);
        ((JavascriptExecutor)driver).executeScript("function simulate(f,c,d,e){var b,a=null;for(b in eventMatchers)if(eventMatchers[b].test(c)){a=b;break}if(!a)return!1;document.createEvent?(b=document.createEvent(a),a==\"HTMLEvents\"?b.initEvent(c,!0,!0):b.initMouseEvent(c,!0,!0,document.defaultView,0,d,e,d,e,!1,!1,!1,!1,0,null),f.dispatchEvent(b)):(a=document.createEventObject(),a.detail=0,a.screenX=d,a.screenY=e,a.clientX=d,a.clientY=e,a.ctrlKey=!1,a.altKey=!1,a.shiftKey=!1,a.metaKey=!1,a.button=1,f.fireEvent(\"on\"+c,a));return!0} var eventMatchers={HTMLEvents:/^(?:load|unload|abort|error|select|change|submit|reset|focus|blur|resize|scroll)$/,MouseEvents:/^(?:click|dblclick|mouse(?:down|up|over|move|out))$/}; " +
                        "simulate(arguments[0],\"mousedown\",0,0); simulate(arguments[0],\"mousemove\",arguments[1],arguments[2]); simulate(arguments[0],\"mouseup\",arguments[1],arguments[2]); ",
                destination,xto,yto);*/
    }

    public void doubleClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }

    public String generateShortName(String base) {
        return base + "_" + LocalDateTime.now().getMinute() + "_" + LocalDateTime.now().getSecond();
    }
}
