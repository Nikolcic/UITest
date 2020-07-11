package test;

import UI.Helper;
import UI.Init;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestClass extends TestBase{

    @BeforeClass
    private void beforeClass() {
        driver = Init.CreateChromeDriver();
        Helper.NavigateToURL(driver, url);
    }

    @Test(priority = 1)
    public void Test() throws InterruptedException {
            Thread.sleep(5000);
    }
}
