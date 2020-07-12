package test;

import UI.Helper;
import UI.Settings.Driver;
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
        WebDriverWait wait = Driver.generateWaits(driver, 5, 10);
        elements = new WebElements(driver);
        x = new TestMethods(driver, wait, elements);
        Helper.NavigateToURL(driver, url);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

    //The + icon creates a new ticket in the correspondent column
    @Test(priority = 1)
    public void Test01_AddTicket()  {
        x.CreateTickets(3,1);
        x.CreateTickets(3,2);
        x.CreateTickets(3,3);
    }

    //Each ticket should be draggable to any other column
    @Test(priority = 2, dependsOnMethods = "Test01_AddTicket")
    public void Test02_DragTicket(){
        x.DragAndDropTickets();
    }

    //Once a user double clicks a ticket. He should be able to edit the content
    @Test(priority = 3, dependsOnMethods = "Test01_AddTicket")
    public void Test03_EditTicket(){
        x.EditTicketWithDoubleCLick();
    }

    //The X icon shows only when the user's mouse hovers a ticket.
    //If it is clicked, it should delete the selected ticket
    @Test(priority = 4, dependsOnMethods = "Test01_AddTicket")
    public void Test04_DeleteTicket(){
        x.DeleteFirstToDoColumnTicket();
    }

    //The number of tickets in the column
    @Test(priority = 5, dependsOnMethods = "Test01_AddTicket")
    public void Test05_VerifyNumberOfTicket(){
        x.CheckCounterOfTickets();

        x.CreateTickets(2,1);
        x.CreateTickets(3,2);
        x.CreateTickets(1,3);

        x.CheckCounterOfTickets();
    }
}
