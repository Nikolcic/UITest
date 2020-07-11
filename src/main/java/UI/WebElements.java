package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebElements {

    public WebElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



}
