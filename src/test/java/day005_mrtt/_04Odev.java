package day005_mrtt;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _04Odev extends BaseClas {
    // Ödev-3
     //  ------------------------------------------------------------
     //http://uitestingplayground.com/
     //"Text Input" linkine tiklayin
    // inputbox'a bir text girin
    // alttaki butona tiklayin
     //butonun text'inin girdiginiz text ildigunu assert edin
   String url="http://uitestingplayground.com";
   By lTextInput=By.linkText("Text Input");
   By lInput=By.id("newButtonName");
   By lutton=By.id("updatingButton");





    @Test
    public void odev3(){
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.linkText("Text Input")).click();
        driver.findElement(By.id("newButtonName")).sendKeys("Murat");
        driver.findElement(By.id("updatingButton")).click();
        Assert.assertTrue(driver.findElement(By.id("updatingButton")).getText().equalsIgnoreCase("murat"));

        sleep(1000);
        driver.quit();
    }
}
