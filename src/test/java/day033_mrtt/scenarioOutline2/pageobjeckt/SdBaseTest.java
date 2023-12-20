package day033_mrtt.scenarioOutline2.pageobjeckt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver1;

import java.time.Duration;

public class SdBaseTest {
    WebDriver driver;
    WebDriverWait wait;

    public SdBaseTest(){
        driver= Driver1.getDrivers();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }
    /*
    public void click(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }*/
    public void click(WebElement element){
        wait.until( driver->{
            try {
                element.click();
                return  true;
            }catch (Exception e){
                return false;
            }
        });

    }
    public void sendkeys(WebElement element,CharSequence...tex){
       wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(tex);

    }
    public void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
