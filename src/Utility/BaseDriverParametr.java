package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParametr {
    public WebDriver driver; // statik olduqu icin birtanede calishtiti ondan paralele teste gore kaldirdik
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    // ilk bu
    public void bashlanqicIhslemleri(String browserTipi) {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);
        if (browserTipi.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else if (browserTipi.equalsIgnoreCase("firefox")) {
            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
            driver = new FirefoxDriver();


        } else {
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);

        }
        // driver.manage().window().maximize();
        Duration dr = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(dr);
        driver.manage().timeouts().implicitlyWait(dr);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        logintest();

    }

    void logintest() {
        System.out.println("Login Test");

        driver.get("https://admin-demo.nopcommerce.com/login");
//        WebElement login = driver.findElement(By.xpath("//a[@class='list-group-item']"));
//        login.click();

        WebElement mail = driver.findElement(By.xpath("//input[@id='input-email']"));
        mail.sendKeys("abdul-533@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Aa199714a");

        WebElement loginEnt = driver.findElement(By.xpath("//input[@type='submit']"));
        loginEnt.click();

        //Assert.assertTrue(driver.getCurrentUrl().equals("https://opencart.abstracta.us/index.php?route=account/account"),"Yalnish girish");
        Assert.assertTrue(driver.getTitle().equals("My Account"));
        //Assert.assertEquals(driver.getTitle(), "My Account", "Login olmadi");


    }

    @AfterClass
    // en son bu
    public void bitishIshlemleri() {

        Tools.Bekle(3);
        driver.quit();
    }

}
