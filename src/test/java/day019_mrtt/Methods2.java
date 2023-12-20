package day019_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Methods2 {
    WebDriver driver;
    WebDriverWait wait;


    public void Methods2(Browsers browser) {// constructor olusturduk
        switch (browser) {
            case Edge:
                driver = new EdgeDriver();
                break;
            case Firefox:
                driver = new FirefoxDriver();
                break;
            case Safari:
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void get(String url) {
        driver.get(url);

    }

    public void clickAlternative(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element)).click(); // once selenium ile click ettik
        } catch (Exception e) {
            try {
                new Actions(driver).click(element).perform(); // sonra actions ile click ettik

            } catch (Exception e1) {
         try {
             JavascriptExecutor js=(JavascriptExecutor) driver;// javascript ile click ettik
             js.executeScript("arguments[0].click();",element);// gelen elemeti 0.argument olarak kabul et

         }catch (Exception e2){
             throw new RuntimeException("element not clickable");// bu sekilde sistemi durdurduk
         }

            }
        }

    }
    public void sendKeys(By locator, String text){
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element,text);

    }
    public void sendKeys(WebElement element,String text){
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
    }
    public void hover(WebElement element){
        new Actions(driver).moveToElement(element).perform();

    }
    public void hover(By locator){
        WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        hover(element);
    }

}


