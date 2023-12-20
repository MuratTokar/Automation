package day027_mrtt.oranhrm;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.Driver1;

import java.time.Duration;

public class BaseTestOrange {

    String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login\n";
    public WebDriver driver;
    public WebDriverWait wait;

    @BeforeTest
    public void start(){
        driver= Driver1.getDrivers();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }
    @AfterTest
    public void afterTest(){
   //  Driver1.quit();








    }
    public void click(By locator){
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void senKeys(By locator,CharSequence...text){
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        senKeys(element,text);
    }


    public void senKeys(WebElement element,CharSequence...text){
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);


    }
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public void assertVisiblity(WebElement element){
        assertVisiblity(element,true);
    }


    public void assertVisiblity(WebElement element,boolean visible){
        if (visible) {
            wait.until(ExpectedConditions.visibilityOf(element));
        }else {
            wait.until(ExpectedConditions.invisibilityOf(element));
        }
    }
}
