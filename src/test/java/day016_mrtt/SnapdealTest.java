package day016_mrtt;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

public class SnapdealTest extends BaseTest {
    /*  https://www.snapdeal.com/
    *  1-watch aratin
       2- listelenenler arasindan random bir ürün secin
       3- o ürüne scroll edin
      4- Ekran görüntüsü ve o ürünün görüntüsünü kaydedin*/
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    By lSuch = By.cssSelector("input[id='inputValEnter']");
    By liste = By.cssSelector(".product-row>section>div");

    WebElement element;
    String url = "https://www.snapdeal.com/";

    @Test
    public void snapdeal() {
        driver.get(url);
        sleep(3000);
        element = driver.findElement(lSuch);
        element.sendKeys("Watch", Keys.ENTER);
        // List<WebElement> urunler=driver.findElements(liste); 1.yol
        List<WebElement> urunler = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(liste));
        int num = new Random().nextInt(urunler.size());
        WebElement myWatch = urunler.get(num);
        new Actions(driver)
                // .sendKeys(Keys.PAGE_DOWN)
                .scrollToElement(myWatch).perform();
        takeScreenShot("MyWatchOage");
        takeScreenShot(myWatch, "MyWatch");

        sleep(5000);

        //
    }

    public void takeScreenShot(String name) {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = name + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".png";
        File target = new File("Screenshots/" + fileName);
        try {
            FileUtils.copyFile(source, target);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


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
            driver.quit();

    }
}

