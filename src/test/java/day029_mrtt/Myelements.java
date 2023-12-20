package day029_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class Myelements {

    public static Myelements $(By locator){
        return  new Myelements(locator);
    }
    private WebDriver driver;
    private WebDriverWait wait;
   private By locator;

    private Myelements(By locator){
       this.locator=locator;
       driver= Driver.getDriver();
       wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public Myelements shouldBe(Conditions conditions){
        switch (conditions){
            case visible:
                wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
                break;
            case clickable:
                wait.until(ExpectedConditions.elementToBeClickable(locator));
                break;
            default:
                wait.until(ExpectedConditions.presenceOfElementLocated(locator));

        }
        return this;
    }
    public Myelements sendKey(String text){
      wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
        return this;
    }
    public Myelements click(){
       wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        return this;
    }
    public Myelements hover(){
        new Actions(driver)
                .moveToElement(driver.findElement(locator)).perform();
        return  this;
    }

}
