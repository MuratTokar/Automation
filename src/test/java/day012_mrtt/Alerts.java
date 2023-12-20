package day012_mrtt;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

import static day012_mrtt.AlertsLocators.*;

public class Alerts extends BaseTest {

  WebDriverWait wait;


    @Test
    public void test_Alerts(){
        driver=new ChromeDriver();
       String a=url;
       driver.get(a);
        wait=new WebDriverWait(driver, Duration.ofSeconds(20));

       allertButton=driver.findElement(lAlertButton);
       allertButton.click();
       driver.switchTo().alert().accept(); // icerdeki ok tiklandi
        sleep(5000);

        confirButton=driver.findElement(lConfirrAlertButton);
        confirButton.click();
        wait.until(ExpectedConditions.alertIsPresent()).dismiss();// hem alert hazir olana kadar bekleyecek hem de
        // ok yapacak  ve switchTo metoduna gerek klamadi
        // driver.switchTo().alert().accept();
        // driver.switchTo().alert().dismiss() ;

        timerallertButton=driver.findElement(lAlertButton);
        timerallertButton.click();

        driver.switchTo().alert().sendKeys("Murat Tokar");
        sleep(3000);
        driver.switchTo().alert().accept();
        sleep(5000);
        driver.quit();

    }
}
