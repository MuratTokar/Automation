package day030_mrtt.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class GmailTest {
    String url="https://mail.google.com";
    String eMail="murattokar26@gmail.com";
    WebDriver driver;
    WebDriverWait wait;
    By emailLog=By.cssSelector("#identifierId");
    By weiter=By.xpath("//button[contains(., 'Weiter')]");


    public GmailTest(){
    }
 @BeforeTest
    public void beforeClass(){

     ChromeOptions options=new ChromeOptions();//maximaize sekilde acildi
     options.addArguments("--start-maximized");//chrome acilmadan bu ozellikler calisir
     options.addArguments("user-data-dir=C:\\Users\\MuratTokar\\AppData\\Local\\Google\\Chrome\\User Data");
     //  options.addArguments("--headless");// chrome gorunmeden test islemleri yurutulur
     driver= new ChromeDriver(options);
     wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }


   @Test
    public void testGmail(){
       driver.get(url);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(emailLog)).sendKeys(eMail);
       // wait.until(ExpectedConditions.elementToBeClickable(weiter)).click();

    }

}
