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

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='button-1 login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List<WebElement> dashBoardMenu;


}
