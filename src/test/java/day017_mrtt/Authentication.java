package day017_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class Authentication extends BaseTest {
    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    //String url = "https://admin:admin@the-internet.herokuapp.com"; bu sekilde de asilabilir.Kullanici adi ve sifre bastakiler
    By basic = By.xpath("//a[text()='Basic Auth']");

    @Test
    public void test1() {
        String url = "https://the-internet.herokuapp.com";

        driver.get(url);
        WebElement element = driver.findElement(basic);
        element.click();
        // acilan sayfada alert gibi gorunen  ve username ,password girlmesi gerekn bir uyari cikar.Buraya selenium ile ulasilamaz
        //Baic,Digest,federal, Authentication .Acilan popup alert degildir
        //bunu asmanin bir yolu;
        // https://siteName.com
        //username:user
        //password:pass
        //Basic authentication
        //https:username:password@siteName.com
        // String url="https://admin:admin@the-internet.herokuapp.com/basic_auth";
        // bu sekilde direkt password ve kullanici adi sormadan gider
        //driver.switchTo().alert().sendKeys("jknjlkjäölkjko"); bu kod hata verir
    }


    @Test
    public void test2() {
        String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";// b u sekilde direkt gider
        driver.get(url);
    }

    @Test
    public void test3() {
        String url = "https://the-internet.herokuapp.com";
        String username = "admin";
        String password = "admin";

        driver.get(url);

        By basicAuth = By.linkText("basic_auth");// sayfaya gittini assertetmek icin

        driver.findElement(basic).click();

        wait.until(ExpectedConditions.urlContains("basic_auth"));

        String url1 = driver.getCurrentUrl().replace("https://", "https://" + username + ":" + password + "@");
        driver.get(url1);

    }

    @Test
    public void test4() {
        String url = "https://the-internet.herokuapp.com";
        String username = "admin";
        String password = "admin";
        driver.get(url);
        By digest = By.xpath("//a[text()='Digest Authentication']");
        WebElement element = driver.findElement(digest);
        element.click();
        wait.until(ExpectedConditions.urlContains("digest_auth"));

        String url1 = driver.getCurrentUrl().replace("https://", "https://" + username + ":" + password + "@");
        driver.get(url1);
        //    driver.navigate().to(url); ustteki ile ayni
        sleep(2000);
        driver.navigate().back();//geri geldik
        driver.navigate().back();//geri geldik
        sleep(2000);
        driver.navigate().refresh();// sayfayi yeniledik
        sleep(2000);
        driver.navigate().forward();// ileri gittik
        sleep(2000);
        driver.quit();

    }

    @Test
    public void test_federalAuthentication() {
        String url = "https://the-internet.herokuapp.com";
        String username = "admin";
        String password = "admin";
        driver.get(url);
        // bu driver.get ile cookie ler olusturlur ve daha sonra basic_authentication gibi girilir

        String url1 = driver.getCurrentUrl().replace("https://", "https://" + username + ":" + password + "@");
        driver.get(url1);
    }
}