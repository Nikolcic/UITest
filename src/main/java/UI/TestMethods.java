package UI;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.*;

public class TestMethods extends Helper {
    private WebElements el;

    public TestMethods(WebDriver driver, WebDriverWait wait, WebElements el){
        super(driver,wait, el);
        this.el = el;
    }

    String task1 = "Task";
    int counter = 0;

    public void CreateTickets(int numberOfTickets, int column) {

        for (int i = 0; i < numberOfTickets; i++) {
            counter++;

            switch (column) {

                case 1:
                    clickWhenReady(el.toDoAddButton);
                    waitForVisible(el.taskNameInput).sendKeys(task1 + counter);
                    el.taskNameInput.sendKeys(Keys.ENTER);
                    assertElementPresent(el.toDoColumnTask(task1 + counter));
                    break;

                case 2:
                    clickWhenReady(el.inProgressAddButton);
                    waitForVisible(el.taskNameInput).sendKeys(task1 + counter);
                    el.taskNameInput.sendKeys(Keys.ENTER);
                    assertElementPresent(el.inProgressColumnTask(task1 + counter));
                    break;

                case 3:
                    clickWhenReady(el.doneAddButton);
                    waitForVisible(el.taskNameInput).sendKeys(task1 + counter);
                    el.taskNameInput.sendKeys(Keys.ENTER);
                    assertElementPresent(el.doneColumnTask(task1 + counter));
                    break;
            }
        }
    }


    public void DragAndDropTickets(){
        String msg = "Ticket was not moved to another column";
        String taskText;

        //Case 1
        taskText = el.toDoColumnTasks().get(0).getText();
        dragAndDropElement(el.toDoColumnTask(taskText), el.inProgressColumnBody);
        assertEquals(taskText, el.inProgressColumnTasks().get(0).getText(), msg);

        //Case 2
        taskText = el.toDoColumnTasks().get(0).getText();
        dragAndDropElement(el.toDoColumnTask(taskText), el.doneColumnBody);
        assertEquals(taskText, el.doneColumnTasks().get(0).getText(), msg);

        //Case 3
        taskText = el.inProgressColumnTasks().get(0).getText();
        dragAndDropElement(el.inProgressColumnTask(taskText), el.toDoColumnBody);
        assertEquals(taskText, el.toDoColumnTasks().get(0).getText(), msg);

        //Case 4
        taskText = el.inProgressColumnTasks().get(0).getText();
        dragAndDropElement(el.inProgressColumnTask(taskText), el.doneColumnBody);
        assertEquals(taskText, el.doneColumnTasks().get(0).getText(), msg);

        //Case 5
        taskText = el.doneColumnTasks().get(0).getText();
        dragAndDropElement(el.doneColumnTask(taskText), el.toDoColumnBody);
        assertEquals(taskText, el.toDoColumnTasks().get(0).getText(), msg);

        //Case 6
        taskText = el.doneColumnTasks().get(0).getText();
        dragAndDropElement(el.doneColumnTask(taskText), el.inProgressColumnBody);
        assertEquals(taskText, el.inProgressColumnTasks().get(0).getText(), msg);
    }

    public void EditTicketWithDoubleCLick(){
        waitForVisible(el.inProgressColumnTasks().get(0));
        WebElement ticket = el.inProgressColumnTasks().get(0);
        doubleClick(ticket);

        try {
            ticket.clear();
            ticket.sendKeys("Task Changed!");
        }
        catch (InvalidElementStateException e){
            e.printStackTrace();
            fail();
        }
    }

    public void DeleteFirstToDoColumnTicket(){
        waitForVisible(el.toDoColumnTasks().get(0));
        String ticketName = el.toDoColumnTasks().get(0).getText();
        WebElement element = el.toDoColumnTasks().get(0);

        hoverOverElement(element);
        clickWhenReady(element);

        assertFalse(element.getText().contains(ticketName));
    }

}

