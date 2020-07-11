package test;

import UI.Helper;
import UI.Settings.Driver;
import UI.Settings.DriverWait;
import UI.TestMethods;
import UI.WebElements;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class TestClass extends TestBase{

    private TestMethods x;
    private WebElements elements;

    @BeforeClass
    private void beforeClass() {
        driver = Driver.CreateChromeDriver();
        WebDriverWait wait = DriverWait.generateWaits(driver, 5, 10);
        elements = new WebElements(driver);
        x = new TestMethods(driver, wait, elements);
        Helper.NavigateToURL(driver, url);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void Test01_AddTicket()  {
        x.CreateTickets(3,1);
        x.CreateTickets(3,2);
        x.CreateTickets(3,3);
    }

    @Test(priority = 2, dependsOnMethods = "Test01_AddTicket")
    public void Test02_DragTicket(){
        x.DragAndDropTickets();
    }

    @Test(priority = 3, dependsOnMethods = "Test01_AddTicket")
    public void Test03_EditTicket(){
        x.EditTicketWithDoubleCLick();
    }

    @Test(priority = 4, dependsOnMethods = "Test01_AddTicket")
    public void Test04_DeleteTicket(){
        x.DeleteFirstToDoColumnTicket();
    }
}
