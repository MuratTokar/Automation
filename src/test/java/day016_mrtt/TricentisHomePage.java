package day016_mrtt;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TricentisHomePage {


    private WebDriver driver;
    private WebDriverWait wait;

    //locators
   String url = "https://demowebshop.tricentis.com/";
    By searchBox = By.xpath("//input[@id=\"small-searchterms\"]");
    By searchButton = By.xpath("//input[@class='button-1 search-box-button']");
    By searchResult = By.xpath("//div[@class='search-results']//div[@class='item-box']");
    By lSearchProduckResults = By.xpath(".//div[@class='item-box']");// basa konulan nokta aktif elemt icin
    String Title = "Demo Web Shop";
    WebElement element = driver.findElement(searchBox);
    public TricentisHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public  void checkTitle(String title){
        Assert.assertEquals(driver.getTitle(), Title);

    }
    public void maximize(){
        driver.manage().window().maximize();

    }
    public void open(String url) {
        driver.get(url);
    }
    public void search(String textToSearch){
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchBox)).sendKeys("comp");
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
    public void gtakeScreenShot() throws IOException {
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        File target = new File("resim.png");// resim gecici olarak buraya geldi
        FileUtils.copyFile(source, target);// resmi kaydedecegimiz asil yer
    }
    //search metodu


}