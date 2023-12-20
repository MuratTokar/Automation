package day016_mrtt;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TestTricents extends BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    String url = "https://demowebshop.tricentis.com/";
    By searchBox = By.xpath("//input[@id=\"small-searchterms\"]");
    By searchButton = By.xpath("//input[@class='button-1 search-box-button']");
    By searchResult = By.xpath("//div[@class='search-results']//div[@class='item-box']");
    By lSearchProduckResults = By.xpath(".//div[@class='item-box']");// basa konulan nokta aktif elemt icin
    String Title = "Demo Web Shop";



    /*
ana sayfaya gidin
sayfanin title sinin "Demo Web Shop" oldugunu assert edin
comp keliemsi ile arama yapin
listelenen urun sayisinin 7 oldugunu assert edin
     */


    @Test
    public void test() throws IOException, InterruptedException {
        //  driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(3000));
        driver.manage().window().maximize();
        open(url);
        WebElement element = driver.findElement(searchBox);
        Assert.assertEquals(driver.getTitle(), Title);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys("comp");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();


        /*Actions actions = new Actions(driver);

       actions.click(element)
                .sendKeys("comp")
                .sendKeys(Keys.ENTER)
                .perform();*/
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("resim.png");// resim gecici olarak buraya geldi
        FileUtils.copyFile(source, target);// resmi kaydedecegimiz asil yer
        Thread.sleep(3000);
        driver.quit();


    }

    public void open(String url) {
        driver.get(url);
    }

    @Test
    public void testScreecshotelement() throws IOException {
        open(url);
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
