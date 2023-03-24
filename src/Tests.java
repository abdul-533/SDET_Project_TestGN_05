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
            elements.dashBoardMenu.get(i).click();
            Assert.assertTrue(elements.dashBoardMenu.get(i).getAttribute("class").contains("menu-is-opening"), "Wrong choice");
        }

//
//        Collections.addAll(menuContent, elements.dashBoardMenu.get(i).getText());
//            for (WebElement e : elements.dashBoardMenu)
//                Assert.assertTrue(menuContent.contains(e.getText()), "wrong choice");
//        }
//


    }

    @Test(priority = 3)
    void Test3() {



    }
}
