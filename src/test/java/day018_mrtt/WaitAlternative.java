package day018_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

import static day018_mrtt.Locators.search;
import static day018_mrtt.Locators.url;

public class WaitAlternative {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void test1() {


        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        wait.until(d -> {
            try {
                if (d.findElement(Locators.search).isDisplayed())
                    return true;
                return false;

            } catch (Exception e) {
                return false;
            }

        });

        Wait<WebDriver> wait1=new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(StaleElementReferenceException.class);
        wait1.until(d->{
            return true;
        });


    }

    public void click(By locator) {
        wait.until(d -> {
            try {
                driver.findElement(locator).click();
                return true;
            } catch (Exception e) {
                return false;
            }


        });


    }
    public void click1(By locator) {
        wait.until(d -> {
            try {
                driver.findElement(locator).click();
                return true;
            } catch (Exception e) {
                try {
                    new Actions(d)
                            .click(driver.findElement(locator))
                            .perform();
                    return true;

                }catch (Exception e2){
                    return false;

                }

            }


        });
        //wait and or kullanimi


    }
}

    class Locators {
        public static By search = By.xpath("//div[@id='search']//input");
        public static By button = By.xpath("//span[@class='input-group-btn']");
        public static String url = "http://opencart.abstracta.us";
    }


