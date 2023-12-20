package day012_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;

public class Calculator {

    String url = "https://bonigarcia.dev/selenium-webdriver-java/slow-calculator.html";
    WebDriver driver;
    WebDriverWait wait;

    @Test
    public void test_calculator(){
        driver=new ChromeDriver();
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(20));

        By lScreen=By.cssSelector(".screen");
        
        driver.findElement(getNumber("2")).click();
        driver.findElement(getNumber("+")).click();
        driver.findElement(getNumber("2")).click();
        driver.findElement(getNumber("=")).click();
        wait.until(ExpectedConditions.textToBe(lScreen,"4"));
        Utils.sleep(3000);
        driver.quit();








    }
    public By getNumber(String num){

      return  By.xpath("//div[@class='keys']//span[text()='" + num + "']");
    }




}