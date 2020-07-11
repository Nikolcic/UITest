package test;

import UI.Helper;
import UI.Vars;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.IOException;

public class TestBase {

    protected WebDriver driver;
    protected String url = "https://milos-kanban-board.netlify.app/";

    @AfterMethod
    public void takeScreenShotOnFailure(ITestResult testResult) {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot scrShot = ((TakesScreenshot)driver);
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(Vars.PROJECT_SCREENSHOT_PATH + Helper.generateFileName());
            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
