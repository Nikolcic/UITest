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

    @BeforeClass
    private void beforeClass() {
        driver = Driver.CreateChromeDriver();
        WebDriverWait wait = DriverWait.generateWaits(driver, 5, 20);
        WebElements elements = new WebElements(driver);
        x = new TestMethods(driver, wait, elements);
        Helper.NavigateToURL(driver, url);
    }

    @AfterClass
    private void tearDown() {
        driver.quit();
    }

    @Test(priority = 1)
    public void Test01_AddTask_DragTask_DeleteTask()  {
        x.createTask();
    }
}
