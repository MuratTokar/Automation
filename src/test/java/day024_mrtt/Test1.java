package day024_mrtt;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver1;

public class Test1 {
    WebDriver driver;
    @BeforeTest
    public void beforeTest(){
        driver= Driver1.getDrivers();
    }
    @Test
    public void test1(){
        driver.get("https://google.com");
    }
    @AfterTest
    public void afterTest(){
        Driver1.quit();
    }
}
