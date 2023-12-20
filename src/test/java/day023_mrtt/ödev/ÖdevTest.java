package day023_mrtt.ödev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class ÖdevTest extends ÖdevLocator {
    /*1-https://demoblaze.com
            2-contact a tiklayin
3-Acilan formda gerekli bilgileri doldurun
4-submit edin
5-popup in ciktigindan ve "Thanks for thr message" yazisinin oldugundan emin olun ve driver i kapatin

    Yapilacaklar:
    xml ile run edilecek
    @BeforeTest xml den browser parametresi alacak
    ve icinde alternatif driverlar tanimlanabilecek
3 tane test tanimlanacak,chrome,edge,firefox paralel calisacak
    form verileri xml den gönderilecek
    Her browser da contact name ve email ayni ,message farkli olacak*/

    WebDriver driver;
    WebDriverWait wait;
    String url="https://demoblaze.com";

    @BeforeTest
    public void beforeTest(){
        driver=new ChromeDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void test1(){
        driver.get(url);
        click(lContack);


    }
    public void click(By locator){
        driver.findElement(locator).click();
    }

}
