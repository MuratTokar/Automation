package day020_mrtt.pom.withFindBy;


import day020_mrtt.pom.withBy.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestWithFindBy {

        WebDriver driver;
        day020_mrtt.pom.withBy.LoginPage lp;

        @BeforeTest
        public void beforeTest(){
            driver= Driver.getDriver();
            driver.manage().window().maximize();

        }

        @Test
        public void test1(){
            lp=new LoginPage(driver);
            lp.gett();
            lp.assertTitle("Swag Labs");
            lp.login("standard_user","secret_sauce");
            lp.assertLogin();

        }

        @AfterTest
        public void tearDown(){
            lp.sleep(3000);

            Driver.quit();
        }
    }


