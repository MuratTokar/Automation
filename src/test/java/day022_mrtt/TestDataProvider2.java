package day022_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class TestDataProvider2 extends BaseTest {
    String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By lusername=By.cssSelector("input[name='username']");
    By lPassworw=By.cssSelector("input[name='password']");
    By lutton=By.cssSelector("button[type='submit']");
    By linvalidCredent=By.xpath("//p[text()='Invalid credentials']");
    By llogin=By.xpath("//h6[text()='Dashboard']");
    By lDrBut=By.xpath("//p[@class='oxd-userdropdown-name']");
    By lOut=By.xpath("//a[text()='Logout']");
    @BeforeTest
    public void setuo() {
        driver = Driver.getDriver();
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void afterTest() {
        sleep(3000);
        driver.quit();
    }

    @Test
    public void start() {
        driver.get(url);

    }

    @Test(dataProvider = "logindata")
    public void login(String username, String password, boolean login) {
        sendkeys(lusername,username);
        sendkeys(lPassworw,password);
        click(lutton);
        if (login){
            wait.until(ExpectedConditions.visibilityOfElementLocated(llogin));
            click(lDrBut);
            sleep(2000);
            click(lOut);
        }else {
            wait.until(ExpectedConditions.visibilityOfElementLocated(linvalidCredent));

        }

    }

    @DataProvider(name = "logindata")
    Object[][] getData() {
        return new Object[][]{
                {"admin1", "1234", false},
                {"admin", "admin123", true},
                {"admin1","admin1234",false},


        };
    }
}