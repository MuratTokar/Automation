package day020_mrtt.testNg;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static day020_mrtt.testNg.Locators.Serach_Button;

public class Test1 extends Test1_Base{
    @Test
    public void testgoogle(){
        driver.get("https://google.com");

    }
    //priority=10 yapsamda testgoogle yi yinede
    // test2 önce calisir cunku dependsOnMethods önceliklidir
    @Test(dependsOnMethods = {"testgoogle"})
    public void test2(){
        driver.findElement(Locators.Google_Accept_Cookie.getLocator()).click();


    }
    @Test(dependsOnMethods = {"testgoogle","test2"})
    public void search(){

        driver.findElement(Serach_Button.getLocator()).sendKeys("Guidersoft", Keys.ENTER);

    }
}
