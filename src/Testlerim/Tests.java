package Testlerim;

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
import java.util.List;

public class Tests extends BaseDriverParametr {
    String passwordStr = "12345678";
    String firstNameStr = "Group8";
    String lastnameStr = "Test3";


    @Test(priority = 1)
    void Test1() {
        Locators elements = new Locators();
        Tools.Bekle(3);
        elements.emptyClick.click();
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
        //elements.loginButton.click();


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
    @Parameters("mail")
    void Test3(String mail) {
        Locators elements = new Locators();
        Tools.Bekle(3);


        elements.customerList.click();
        elements.customers.click();
        elements.add.click();

        Tools.Bekle(3);


        elements.email.sendKeys(mail);
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
    @Parameters("mail")
    void Test4(String mail) {
        Locators elements = new Locators();
        Tools.Bekle(3);
//        elements.customerList.click();
        elements.customers.click();


        elements.searchEmail.sendKeys(mail);
        elements.searchFirstName.sendKeys(firstNameStr);
        elements.searchLastName.sendKeys(lastnameStr);
        elements.searchButton.click();

        WebElement el = driver.findElement(By.xpath("(//table[@class='table table-bordered table-hover table-striped dataTable no-footer'])[2]"));
        Assert.assertTrue(el.getText().contains(mail));
        Tools.Bekle(2);

        elements.edit.click();

        elements.commend.clear();
        elements.commend.sendKeys("Good bye");
        elements.save.click();

        Assert.assertTrue(elements.succes.getText().contains("successfully"), "wrong choice");


    }

    @Test(priority = 5)
    @Parameters("mail")
    void Test5(String mail) {
        Locators elements = new Locators();

       // elements.customerList.click();
        Tools.Bekle(2);
        //elements.customers.click();

        elements.searchEmail.sendKeys(mail);

        elements.searchFirstName.sendKeys(firstNameStr);

        elements.searchLastName.sendKeys(lastnameStr);
        elements.searchButton.click();

        elements.edit.click();
        elements.delete.click();
        elements.delete2.click();
        Assert.assertTrue(elements.succes.getText().contains(" deleted successfully"), "wrong choice");


    }

    @Test(priority = 6)
    void Test6() {
        Locators elements = new Locators();
        elements.serch2.sendKeys("shipments");
        elements.serch3.click();
        Assert.assertTrue(elements.shipmentMSG.getText().toLowerCase().contains("shipments"));


    }

}
