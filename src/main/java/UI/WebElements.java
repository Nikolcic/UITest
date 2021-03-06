package UI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WebElements {

    public WebDriver driver;

    public WebElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(css = ".dNrDWH .sc-Axmtr")
    public WebElement toDoAddButton;

    @FindBy(css = ".ixvuvG .sc-Axmtr")
    public WebElement inProgressAddButton;

    @FindBy(css = ".gtsVWf .sc-Axmtr")
    public WebElement doneAddButton;

    @FindBy(css = ".sc-AxjAm")
    public WebElement taskNameInput;

    @FindBy(css = ".gmvgXk")
    public WebElement toDoColumnBody;

    @FindBy(css = ".bmXcrz")
    public WebElement inProgressColumnBody;

    @FindBy(css = ".iFWCam")
    public WebElement doneColumnBody;

    public WebElement toDoColumnTask(String task){
        return driver.findElement(By.xpath("//h2[text()='To Do']/../..//span[text()='"+task+"']"));
    }

    public WebElement inProgressColumnTask(String task){
        return driver.findElement(By.xpath("//h2[text()='In rogress']/../..//span[text()='"+task+"']"));
    }

    public WebElement doneColumnTask(String task){
        return driver.findElement(By.xpath("//h2[text()='Doe']/../..//span[text()='"+task+"']"));
    }

    public WebElement toDoTaskDeleteButton(String task){
        return driver.findElement(By.xpath("//h2[text()='To Do']/../..//span[text()='"+task+"']/../button[@class='sc-AxiKw eSbheu'"));
    }

    public WebElement inProgressTaskDeleteButton(String task){
        return driver.findElement(By.xpath("//h2[text()='In rogress']/../..//span[text()='"+task+"']/../button[@class='sc-AxiKw eSbheu'"));
    }

    public WebElement doneTaskDeleteButton(String task){
        return driver.findElement(By.xpath("//h2[text()='Doe']/../..//span[text()='"+task+"']/../button[@class='sc-AxiKw eSbheu'"));
    }

    public WebElement toDoNumberOfTask(){
        return driver.findElement(By.xpath("//h2[text()='To Do']/..//div[@class='sc-fzozJi dteCCc']"));
    }

    public WebElement inProgressNumberOfTask(){
        return driver.findElement(By.xpath("//h2[text()='In rogress']/..//div[@class='sc-fzozJi dteCCc']"));
    }

    public WebElement doneNumberOfTask(){
        return driver.findElement(By.xpath("//h2[text()='Doe']/..//div[@class='sc-fzozJi dteCCc']"));
    }

    public List<WebElement> toDoColumnTasks(){
        return driver.findElements(By.xpath("//h2[text()='To Do']/../..//div[@class='sc-AxirZ KfkWX']"));
    }

    public List<WebElement> inProgressColumnTasks(){
        return driver.findElements(By.xpath("//h2[text()='In rogress']/../..//div[@class='sc-AxirZ cETdWL']"));
    }

    public List<WebElement> doneColumnTasks(){
        return driver.findElements(By.xpath("//h2[text()='Doe']/../..//div[@class='sc-AxirZ haeNPs']"));
    }
}
