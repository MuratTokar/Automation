package day021_mrtt.Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestDemoBlase {
    WebDriver driver;
    WebDriverWait wait;
    Locators ls=new Locators(driver);
    @BeforeTest
    public void beforTest(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));



    }
    @AfterTest
    public void afterTest(){
     driver.quit();
    }
    @Test
    public void test1(){

        driver.get(ls.url);
        ls.ePhonelink.click();


        Utils.sleep(3000);
        for (WebElement product: ls.urunlist){
            System.out.println(product.getText());
        }


    }
    @Test
    public void test3_fillTheProducksClass(){
        driver.get(ls.url);
        Utils.sleep(3000);
        List<Produck> products=new ArrayList<>();
        for (WebElement produk: ls.products){
            WebElement link=produk.findElement(By.cssSelector("a"));
            String name=link.getText();
            String priceStr=produk.findElement(By.cssSelector("h5")).getText();
            int price=Integer.parseInt(priceStr.replaceAll("[^0-9]","").trim());
            String description=produk.findElement(By.id("article")).getText();

          //  products.add(new Produck(link,name,price,description));

        }
        for (Produck product:products){
            System.out.println(product);
        }

    }
}
