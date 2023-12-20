package day033_mrtt.scenarioOutline2.pageobjeckt;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SdPage extends SdBaseTest{
    final String url="https://www.saucedemo.com/";
    /*
    public SdPage(){
        PageFactory.initElements(driver,this);// base testte de yapabiliriz
    }*/

    @FindBy(id="user-name")
   public WebElement lusername;
    @FindBy(xpath = "//input[@id='password']")
   public WebElement lpassword;
    @FindBy(css = "input[type='submit']")
   public WebElement llogin;
    @FindBy(xpath = "//div[@id='shopping_cart_container']")
   public WebElement lshopcart;
    @FindBy(xpath = "//h3[@data-test=\"error\"]")
   public WebElement lerror;

    public void gotopage(){
        driver.get(url);
    }

}
