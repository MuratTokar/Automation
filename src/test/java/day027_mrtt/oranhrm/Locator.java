package day027_mrtt.oranhrm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Locator {
    /* Locator(){
         PageFactory.initElements(Driver1.getDrivers(),this); // burda constructor olustrup test claass ta sadece
         Locator=new Locator da diyebiliriz

     }*/
    @FindBy(xpath = "//input[@name='username']")
    WebElement lUsername;
    @FindBy(xpath = "//input[@name='password']")
    WebElement lPassword;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement lSubmit;
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    WebElement loginAssert;
    @FindBy(xpath = "//span[text()='Admin']")
    WebElement Admin;
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement AddButton;
    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    WebElement selects1;
    @FindBy(xpath = "(//div[text()='-- Select --'])[1]")
    WebElement selects2;
    @FindBy(xpath = "//span[text()='ESS']//parent::div")
    WebElement Ess;
    @FindBy(xpath = "//span[text()='Enabled']//parent::div")
    WebElement enabled;
    @FindBy(xpath = "//input[@type='password'] [1]")
    WebElement password;
    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement empName;
    @FindBy(xpath = "//span[text()='Ariane  Lowe']")
    WebElement Ariane;


}
