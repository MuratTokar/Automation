package day020_mrtt.testNg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Test1_Base {
    /*
     Suite

        Test

           Group

             Class

                Method

                test basladiginda bu driver in otomatik tanimlanmasini istiyorsam  @BeforSuite icine tanimlarim
                ve testlerden önce calisacaktir
    */
    WebDriver driver;
    @BeforeSuite
    public void beforSuite(){
        driver=new ChromeDriver();
    }
    @AfterSuite
    public void afterSuite(){
      driver.quit();
    }
}
