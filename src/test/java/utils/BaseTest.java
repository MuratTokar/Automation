package utils;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class BaseTest {
 public WebDriver driver;
 public WebDriverWait wait;


    public  void sleep() {
        sleep(1000);
    }



    public  void sleep(long millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void scrollBy(int y){
        JavascriptExecutor js=(JavascriptExecutor) driver;     // scroll icin javascript kullanirirz
        js.executeScript("window.scrollBy(0,"+y+")");   // kaydirma yaptik
    }
    public void scrollTo(int y){
        scrollTo(0,y);

    }
    public void scrollTo(int x,int y){
        JavascriptExecutor js=(JavascriptExecutor) driver;     // scroll icin javascript kullanirirz
        js.executeScript("window.scrollBy(0,"+y+","+y+")");   // kaydirma yaptik
    }

    public void takeScreenShot(WebElement element, String name) {

        File source = element.getScreenshotAs(OutputType.FILE);
        String fileName = name + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".png";
        File target = new File("Screenshots/" + fileName);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void click(By locator){
        driver.findElement(locator).click();

    }


    public void sendkeys(By locator,CharSequence...text){
        WebElement eUsername = driver.findElement(locator);
        eUsername.clear();
        eUsername.sendKeys(text);
    }
    public void scrollIntoView(WebElement element){
        scrollIntoView(element,true);

    }
    public void scrollIntoView(WebElement element,boolean up){
        JavascriptExecutor js = (JavascriptExecutor) driver;     //
        js.executeScript("arguments[0].scrollIntoView(" + up + ");",element);
    }
    public void clickByJs(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;     // scroll icin javascript kullanirirz
        js.executeScript("arguments[0].click);", element);   // kaydirma yaptik



    }


    public void hover(By locator){
        WebElement element=wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        hover(element);

    }
    public void hover(WebElement element){
        new Actions(driver).moveToElement(element).perform();
    }
    public void takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = name + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".png";
        File target = new File("Screenshots/" + fileName);


    }
    }
