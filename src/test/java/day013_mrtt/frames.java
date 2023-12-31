package day013_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class frames extends BaseTest {

    WebDriverWait wait;
    String url="https://bonigarcia.dev/selenium-webdriver-java/iframes.html";
    // eger locater im iframe icindeyse driver.switchTo().frame(...); ile o iframe icine girilmesi gerekir.
    //sonra ana pencerde islem yapilacaksa tekrar ana pencereye dönülmeli
    //
    @Test
    public void test_frame1()  {
        By lLorem=By.xpath("//*[contains(text(),'Lorem ipsum')]");
        By lframe=By.id("my-frame");
        driver= Driver.getDriver();
        wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(url);

        // aranan elemnt iframe icinde oldugu icin iframe switch ediyoruz


        // iframe id`si yada name si ile switch edilebilir
        driver.switchTo().frame("my-iframe");

        // iframe element olarak tanimlanir ve switc edilebilir
        sleep(4000);
        WebElement iframe=driver.findElement(lframe);
        driver.switchTo().frame(iframe);

        // iframe index ile switch edilebilir
        driver.switchTo().frame(0);

        wait.until(ExpectedConditions.visibilityOfElementLocated(lLorem));


        // burda bekleme yok
       // Assert.assertTrue(driver.findElement(lLorem).isDisplayed());
        driver.quit();


    }
    @Test
    public void test_2(){
        String url="https://bonigarcia.dev/selenium-webdriver-java/iframes.html";
        By locator=By.xpath("//*[contains(text(),'Lorem ipsum')]");

        driver=Driver.getDriver();
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        driver.get(url);
        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        driver.switchTo().parentFrame();// iframe den cikardik

        String h5=driver.findElement(By.cssSelector("h5")).getText();
        System.out.println(h5);

        driver.quit();
    }
    @Test
    public void test_3(){
        String iframe="frame1";
        By lparentFrame=By.id("frame1");
        By lchilFrame=By.xpath("//p[text()='Child Iframe']");
        driver=Driver.getDriver();
        String url="https://demoqa.com/nestedframes";
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));

        driver.get(url);

        driver.findElement(lparentFrame);
        driver.switchTo().frame(iframe);//ilk iframe nin icine girdik


        sleep(4000);
        driver.switchTo().frame(0);
        driver.findElement(lchilFrame);
        sleep(3000);
        driver.switchTo().parentFrame();
        sleep(3000);
        driver.quit();


    }
    @Test
    public void test4(){

        driver=Driver.getDriver();
        String url="https://the-internet.herokuapp.com/iframe";
        wait=new WebDriverWait(driver,Duration.ofSeconds(10));



        By lButton=By.xpath("//button[@title='Bold']");
        By lIframe=By.cssSelector("div.tox-edit-area > iframe");
        By lIframeBody=By.id("tinymce");

        driver.get(url);
        wait.until(ExpectedConditions.elementToBeClickable(lButton)).click(); // butona gidip tikladik
       // click(lButton); boylede olur

        driver.switchTo().frame(driver.findElement(lIframe));// driveri iframe ninin icine gonderdik
        //driver.switchTo().frame(0);
        WebElement body=driver.findElement(lIframeBody); // text ekranina giitik
        body.clear();
        body.sendKeys("Murat Tokar"); // metin gonderdik

        sleep(5000);


        driver.quit();





    }
}
