package day023_mrtt.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeTest
    @Parameters("browser")
    public void beforeTest(@Optional("chrome") String browser){
        if (browser.trim().equalsIgnoreCase("firefox")) // testleri ayri ayri browserlerden yapmak icin
            //eger burdan run etsek browser gondermedik diye sorun olacak.Bunun iicn optional eklemeliyiz
            // yani herhangi bir parametre gelmese chrome ile yap
            driver=new EdgeDriver();
        else
            driver=new ChromeDriver();

        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
