package day019_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Methods {
    WebDriver driver;

    WebDriverWait wait;

    public Methods() {
        this("chrome");

    }

    public Methods(String browser) {
        setDriver(browser);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void get(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public void setDriver(String browser) {
        if (browser.equalsIgnoreCase("edge"))
            driver = new EdgeDriver();
        else
            driver = new ChromeDriver();
    }


    public void get(String url, String title) {
        driver.get(url);
        if (title.length() > 0)
            Assert.assertTrue(titleContains(title));

    }

    public boolean titleContains(String title) {
        return driver.getTitle().contains(title);
    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
        //wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void clickAlternativ(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            new Actions(driver)
                    .click()
                    .perform();
            //  }catch (Exception e1){
            throw new RuntimeException("Element not clickable");
        }
    }



}



