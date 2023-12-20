package day020_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoqaTest {
    WebDriver driver;

    @BeforeTest
    public void befortest(){

        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    @AfterTest
    public void aftertest(){

      driver.quit();

    }
    @Test
    public void tes1(){
        BasDemoqa   bs=new BasDemoqa(driver);
        bs.getUrl();

        bs.sendKeys(bs.eUsername, "Murat Tokar");
        bs.sendKeys(bs.eUsermail, "murattokar26@gmail.com");
        bs.sendKeys(bs.eCurrentAdres, "Horhor cikmazi");
        bs.sendKeys(bs.eFermanentAdress, "Prinzenstr.60");
        bs.scrollBy(500);
        bs.click(bs.eSubmit);


    }

}
