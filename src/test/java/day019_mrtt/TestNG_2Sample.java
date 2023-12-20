package day019_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Utils;

public class TestNG_2Sample {
    WebDriver driver;
    @BeforeClass
    public void beforeClasse(){
        driver=new ChromeDriver();
    }
   /* @Test(priority =1)// priority dusuk olan once calisir
    public void testt1(){

    }
    @Test(invocationCount = 4)// bu test 4 defa tekrarli calisir
    public void testt2(){

    */
    /*
    * Test NG de test metotolarina priority veya dependency verilmez ise siralama  metot isimlerine göre yapilir
    * Priority:-5000 +5000 en dusuk olan en once calisir.Siralam esit olursa isme gore calisir*/
    @Test(testName = "T3")
    public void test3(){
        driver.get("https://google.com"); // isim sirasin agore calisir
    }
    @Test(testName = "T2",priority = 2)//Priority dusuk olani once calisr .yani once T3 celisacak cunku default o
    public void test2(){
        driver.get("https://yahoo.com");
    }
    @AfterClass
    public void afterClasse(){
        Utils.sleep(3000);
        driver.quit();
    }
}
