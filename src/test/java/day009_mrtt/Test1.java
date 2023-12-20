package day009_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Utils;

import java.util.List;



public class Test1 {
    WebDriver driver;
    String url= "https://practice.expandtesting.com/login";
    By lUsername=By.cssSelector("#username");
    By lPassword=By.cssSelector("#password");
    By lButton=By.xpath("//button[@type='submit']");
    By lisVisible=By.xpath("//h1[text()='Secure Area']");
    By logout=By.xpath("//i[text='Logout']");
    By lisLogout=By.xpath("//h1[text()='Login Page']");

@Test
public void test1(){
    driver=Driver.getDriver("edge");
    driver.get("https://google.com");

    driver=Driver.getDriver("edge");
    driver.get("https://yahoo.com");

    driver=Driver.getDriver();
    driver.get("https://google.com");
}
    @Test
    public void test2() throws InterruptedException {
        // biz her drive acinca yeni degilde onceki ile devam etsin istiyorsak Driver class ta private yapmaliyiz
       // driver=Driver.getDriver();// ama burda kac kez driver cagirsam o kadar safya acar
       // driver=Driver.getDriver();// ama burda kac kez driver cagirsam o kadar safya acar
        driver=Driver.getDriver();// ama burda kac kez driver cagirsam o kadar safya acar
        driver.get(url);

        // username ve password girin
      WebElement elm=  driver.findElement(lUsername);
        Thread.sleep(3000);
        elm.sendKeys("practice");

        driver.findElement(lPassword).sendKeys("SuperSecretPassword!");

        //login butonuna tikla
        driver.findElement(lButton).click();

        // login butonunun background-color consola yazdirin
        System.out.println(driver.findElement(lButton).getCssValue("background-color"));

        // login oldugunuzu "Secure Area" yada logout linki ile assert edin
        Assert.assertTrue(driver.findElement(lisVisible).isDisplayed());

        // logout a tiklayin
        driver.findElement(logout).click();

        // "login page" yazisi ya da login butonu ile ciktiginizi assert edin
        Assert.assertTrue(driver.findElement(lisLogout).getText().equalsIgnoreCase("Login Page"));

        driver.quit();
    }
    @Test
    public void testSelectBox(){ // selecte ozel metot var
        driver=Driver.getDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        WebElement selectElement=driver.findElement(By.cssSelector("select[name='dropdown']"));
        Select select=new Select(selectElement);

        //select elementinin 3 index li option u secer
        select.selectByIndex(3);
        Utils.sleep(2000);

        //select elementinin value si "dd6" olan optinon ini secer
        select.selectByValue("dd6");
        Utils.sleep(2000);

     // select elementinin görunrn text i "Drop Down Item 1" olan optinon ini secer
        select.selectByVisibleText("Drop Down Item 1");

        System.out.println("select.isMultiple() = " + select.isMultiple());

        List<WebElement> options=select.getOptions();
        for (WebElement option:options){
            System.out.println(option.getText());
        }
       // Driver.quit();


    }
    @Test
    public void elementInElement(){
        ////input[@type='text' and not(@hidden)]
        driver=Driver.getDriver();
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        By lForm=By.cssSelector("#HTMLFormElements");
       WebElement form=driver.findElement(lForm);
        //form[@id='HTMLFormElements']//input[@type='text' and not(@hidden)]
       By linput=By.xpath(".//input[@type='text' and not(@hidden)]"); //usttekinin  ikinci kismi aldik
      // driver.findElement(linput).sendKeys("name");1- burda find elemnt ile de gonderirirz
        // element altina element bulurken xpath kullanniliyor ise xpath in basina (.) nokta eklenir
        // yani =current element
      form.findElement(linput).sendKeys("name");//2- form elemntinin altinda ariyor

        //element in element
       // driver.findElement(By.id("")).findElement(By.cssSelector("")).findElement(By.xpath(".//"));
    }
}
