package day027_mrtt.oranhrm;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Ortest extends BaseTestOrange {

    Locator locator;

    @BeforeClass
    public void setup() {
        locator = PageFactory.initElements(driver, Locator.class);// By find almak icin
    }

    @Test(priority = 1)
    public void test1() {
        driver.get(url);
        senKeys(locator.lUsername, "Admin");
        senKeys(locator.lPassword, "admin123");
        click(locator.lSubmit);
        assertVisiblity(locator.loginAssert);

    }
    @Test(priority = 2)
    public void test2() {

        click(locator.Admin);
        click(locator.AddButton);
       // sleep(3000);
        click(locator.selects1);
      //  sleep(3000);
        click(locator.Ess);
      //  sleep(3000);
        click(locator.selects2);
      //  sleep(3000);
        click(locator.enabled);
        senKeys(locator.password,"a123456");
        senKeys(locator.empName,"Ari");
        sleep(3000);
      //  click(locator.Ariane);
    }

}
