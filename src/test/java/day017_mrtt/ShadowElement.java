package day017_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ShadowElement extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver=Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();

    }
    // shadow dom,web sayfasinda locator bulamayabiliriz,direkt ulasilmaz
    //shadow root elementi bulunur.Oda genellille shadow root un ustunde olur

    String url="https://bonigarcia.dev/selenium-webdriver-java/shadow-dom.html";
    @Test
    public void sahdowTest(){
        driver.get(url);
        By shadowElement=By.xpath("//div[@id='content']");
        WebElement p= driver
                .findElement(shadowElement)//altindaki shadow root u bul
                .getShadowRoot()// shadow root un altindaki p
                .findElement(By.cssSelector("p"));
        String text=p.getText();
        System.out.println(text);
        //driver.quit();



    }
}

