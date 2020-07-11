package UI;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestMethods extends Helper {
    private WebElements el;

    public TestMethods(WebDriver driver, WebDriverWait wait, WebElements el){
        super(driver,wait, el);
        this.el = el;
    }

    String task1 = "Task1";
    String task2 = "Task2";
    String task3 = "Task3";
    String task4 = "Task4";
    String task5 = "Task5";

    public void createTask(){
        clickWhenReady(el.toDoAddButton);
        waitForVisible(el.taskNameInput).sendKeys(task1);
        el.taskNameInput.sendKeys(Keys.ENTER);

        assertElementPresent(el.toDoColumnTask(task1));
    }
}
