package day016_mrtt;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestTricents1  {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();

    }

    /*
ana sayfaya gidin
sayfanin title sinin "Demo Web Shop" oldugunu assert edin
comp keliemsi ile arama yapin
listelenen urun sayisinin 7 oldugunu assert edin
     */
    TricentisHomePage hp=new TricentisHomePage(Driver.getDriver());

    @Test
    public void test() throws IOException {
        //  driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(3000));
        hp.maximize();


    hp.checkTitle("Demo Web Shop");
    hp.search("comp");
    hp.gtakeScreenShot();



        /*Actions actions = new Actions(driver);

       actions.click(element)
                .sendKeys("comp")
                .sendKeys(Keys.ENTER)
                .perform();*/


        driver.quit();
    }

    @Test
    public void testScreecshotelement() throws IOException {
        hp.open(hp.url);
        By lsearchButton = By.xpath("//input[@class='button-1 search-box-button']");
        By lsearchBox = By.xpath("//input[@id=\"small-searchterms\"]");
        WebElement element = driver.findElement(lsearchBox);
        element.click();
        element.sendKeys("comp");
        WebElement element1 = driver.findElement(lsearchButton);
        element1.click();
        WebElement element2 = driver.findElement(By.xpath("//div[@class='item-box'][1]"));
        File ilkgoruntu = element2.getScreenshotAs(OutputType.FILE);
        File target = new File("resim.png");
        FileUtils.copyFile(ilkgoruntu, target);

    }
}
