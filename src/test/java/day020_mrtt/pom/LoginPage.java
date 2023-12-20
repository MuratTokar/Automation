package day020_mrtt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {

   private String url="https://www.saucedemo.com/";

   @FindBy(id="user-name")//  @FindBy(how = How.ID,using = "user-name") böylede yazilabilir
   private WebElement eUsername;
  // private By lUsername=By.id("user-name");

    @FindBy(css ="input[id='password']" )
    private WebElement ePassword;
  // private By lPassword=By.cssSelector("input[id='password']");

    @FindBy(id ="login-button" )
    private WebElement eLoginButton;
 //  private   By lLoginButton=By.id("login-button");

    @FindBy(css = ".app_logo")
    private WebElement eAppLogo;
  // private By lApplogo=By.cssSelector(".app_logo");

    public LoginPage(WebDriver driver) {
        super(driver);

        // bu initialize olmazsa element olusturulamaz.Burda baska bir sayfayi kullanacaksam o sayfanin ismini de yazabilirim
        PageFactory.initElements(driver,this);
       // PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this); gecikmeler icin kullanilir

    }
    public void gett(){
        driver.get(url);
    }
    public void assertTitle(String title){
        Assert.assertEquals(driver.getTitle(),title);

    }
    public void login(String username,String password){
        sendKeys(eUsername,username);// bu sekilde olur
       // eUsername.sendKeys(username); // bu sekilde de olur
        sendKeys(ePassword,password);
        click(eLoginButton);




    }
    public void assertLogin() {
         wait.until(ExpectedConditions.visibilityOf(eAppLogo));

    }
}

