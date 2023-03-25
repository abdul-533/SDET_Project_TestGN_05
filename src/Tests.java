import Utility.BaseDriver;
import Utility.BaseDriverParametr;
import Utility.Tools;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Tests extends BaseDriver {
    String emailstr = "Grouppp8@gmail.com";
    String passwordStr = "12345678";
    String firstNameStr = "Group8";
    String lastnameStr = "Test3";

    @Test(priority = 1)
    void Test1() {
        Locators elements = new Locators();

        Tools.Bekle(3);
        elements.email.clear();
        elements.password.clear();
        elements.email.sendKeys("admin@yourstore.com");
        elements.password.sendKeys("admin");
        elements.loginButton.click();

        Assert.assertTrue(driver.getCurrentUrl().contains("admin"), "Yalnish girish");

    }

    @Test(priority = 2)
    void Test2() {
        Locators elements = new Locators();

        List<String> menuContent = new ArrayList<>();

        for (int i = 1; i < elements.dashBoardMenu.size(); i++) {
            Tools.Bekle(1);
            elements.dashBoardMenu.get(i).click();
            Assert.assertTrue(elements.dashBoardMenu.get(i).getAttribute("class").contains("menu-is-opening"), "Wrong choice");
        }

        for (int i = 0; i < elements.dashBoardMenu.size(); i++) {
            Assert.assertNotNull(elements.dashBoardMenu.get(i).getText(), "Wrong choice");

        }


    }

    @Test(priority = 3)
    void Test3() {


        Locators elements = new Locators();
//        Tools.Bekle(3);
//        elements.email.clear();
//        elements.password.clear();
//        elements.email.sendKeys("admin@yourstore.com");
//        elements.password.sendKeys("admin");
//        elements.loginButton.click();


        elements.customerList.click();
        elements.customers.click();
        elements.add.click();


        elements.email.sendKeys(emailstr);
        elements.password.sendKeys(passwordStr);
        elements.firstName.sendKeys(firstNameStr);
        elements.lastName.sendKeys(lastnameStr);
        elements.gender.click();
        Tools.Bekle(2);
        elements.dateOfBirth.sendKeys("03/24/1997");
        elements.company.sendKeys("Tecxhno Study");
        elements.taxExemp.click();
        Tools.Bekle(2);

        elements.newsletter.click();
        WebElement e1 = driver.findElement(By.xpath("//li[text()='Your store name']"));
        e1.click();


        Tools.Bekle(2);
        Select sc2 = new Select(elements.manager);
        sc2.selectByIndex(1);
        elements.active.click();
        elements.commend.sendKeys("Hello");
        elements.save.click();

        Assert.assertTrue(elements.succes.getText().contains("successfully"), "wrong choice");


    }

    @Test(priority = 4)
    void Test4() {


        Locators elements = new Locators();
        elements.email.clear();
        elements.password.clear();
        elements.email.sendKeys("admin@yourstore.com");
        elements.password.sendKeys("admin");
        elements.loginButton.click();


        elements.customerList.click();
        elements.customers.click();


        elements.searchEmail.sendKeys(emailstr);
        elements.searchFirstName.sendKeys(firstNameStr);
        elements.searchLastName.sendKeys(lastnameStr);
        elements.searchButton.click();

        WebElement el = driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped dataTable no-footer'])[2]"));
        Assert.assertTrue(el.getText().contains(emailstr));
        Tools.Bekle(2);

        elements.edit.click();

        elements.commend.clear();
        elements.commend.sendKeys("Good bye");
        elements.save.click();

        Assert.assertTrue(elements.succes.getText().contains("successfully"), "wrong choice");


    }

}
