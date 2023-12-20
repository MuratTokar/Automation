package day020_mrtt.pom.withBy;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.util.List;


public class Test1 {
    public static void main(String[] args) {
        Produckt p=new Produckt();

    }

    WebDriver driver;
    LoginPage lp;
    ProductPage pp;
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
    @Test(dependsOnMethods = {"test1"})
    public void testProduct(){
        pp=new ProductPage(driver);
        List<String> names=pp.getlistOfProduksNames();
        System.out.println(names);

    }
    @AfterTest
    public void tearDown(){
        lp.sleep(3000);

        Driver.quit();
    }
}
