import Utility.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//org.seleniumhq.selenium:selenium-java:4.8.1
//org.testng:testng:6.14.3

import java.util.List;

public class Locators {
    public Locators() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath = "")
    public WebElement locator1;

    @FindBy(xpath = "")
    public WebElement locator2;

    @FindBy(xpath = "")
    public WebElement locator3;



}
