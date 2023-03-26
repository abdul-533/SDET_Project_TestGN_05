package Testlerim;

import Utility.BaseDriver;
import Utility.BaseDriverParametr;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//org.seleniumhq.selenium:selenium-java:4.8.1
//org.testng:testng:6.14.3

import java.util.List;

public  class Locators {
    public Locators() {
        PageFactory.initElements(BaseDriverParametr.driver, this);
    }

    @FindBy(xpath = "//input[@class='email valid']")
    public WebElement email;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//*[@class='button-1 login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List<WebElement> dashBoardMenu;

    @FindBy(xpath = "//i[@class='nav-icon far fa-user']")
    public WebElement customerList;

    @FindBy(xpath = "//*[text()=' Customers']")
    public WebElement customers;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement add;

//    @FindBy(xpath = "//input[@name='Email']")
//    public WebElement email2;
//
//    @FindBy(xpath = "//input[@name='Password']")
//    public WebElement password2;

    @FindBy(xpath = "//input[@name='FirstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='LastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='Gender']")
    public WebElement gender;

    @FindBy(xpath = "//input[@id='DateOfBirth']")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//input[@name='Company']")
    public WebElement company;

    @FindBy(xpath = "//input[@name='IsTaxExempt']")
    public WebElement taxExemp;

    @FindBy(xpath = "//div[@role='listbox']")
    public WebElement newsletter;

    @FindBy(xpath = "(//div[@role='listbox'])[2]")
    public WebElement customerRoles;

    @FindBy(xpath = "//select[@id='VendorId']")
    public WebElement manager;

    @FindBy(xpath = "//input[@class='check-box']")
    public WebElement active;

    @FindBy(xpath = "//textarea[@class='form-control']")
    public WebElement commend;

    @FindBy(xpath = "//button[@name='save']")
    public WebElement save;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement succes;

    @FindBy(xpath = "//div[text()='Search']")
    public WebElement search;

    @FindBy(xpath = "//input[@id='SearchEmail']")
    public WebElement searchEmail;

    @FindBy(xpath = "//input[@id='SearchFirstName']")
    public WebElement searchFirstName;

    @FindBy(xpath = "//input[@id='SearchLastName']")
    public WebElement searchLastName;

    @FindBy(xpath = "//button[@id='search-customers']")
    public WebElement searchButton;

    @FindBy(xpath = "//i[@class='fas fa-pencil-alt']")
    public WebElement edit;

    @FindBy(xpath = "//span[@id='customer-delete']")
    public WebElement delete;

    @FindBy(xpath = "//button[@class='btn btn-danger float-right']")
    public WebElement delete2;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement serch2;

    @FindBy(xpath = "//strong[text()='Shipments']")
    public WebElement serch3;

    @FindBy(xpath = "//h1[@class='float-left']")
    public WebElement shipmentMSG;






}
