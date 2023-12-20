package day021_mrtt.Listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Test2 extends BaseTest {

    String url = "https://demoqa.com/progress-bar";

    //@FindBy(css = "#startStopButton")
    By lButton = By.cssSelector("#startStopButton");
    By lprogresbar = By.cssSelector("#progressBar>div");


    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterTest
    public void afterTest() {
        sleep(3000);
        driver.quit();
    }

    @Test
    public void test1() {
        driver.get(url);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lButton));
        // WebElement element=driver.findElement(lButton);
        // element.click();

    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() throws IOException {
        WebElement startbutton = driver.findElement(lButton);
        startbutton.click();
        int prosent = 0;

        do {
            String wall = driver.findElement(lprogresbar).getAttribute("aria-valuenow");
            prosent = Integer.parseInt(wall);
        } while (prosent <= 80);
        startbutton.click();
        gtakeScreenShot();


    }
    public void gtakeScreenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("resim.png");// resim gecici olarak buraya geldi
        FileUtils.copyFile(source, target);// resmi kaydedecegimiz asil yer
    }
}