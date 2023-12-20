package day008_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Senariolar {
    WebDriver driver;
    //Senariolar()  // constructorlari sildik initializer yani suslu parantezler
    // kaldi ve bu constructordan once calisir
    // birde static initializer var ve bir kez calisir
    By lElemts=By.xpath("//div[@class='category-cards']/div[.//*[text()='Elements']]");
    // By lElemts=By.xpath("//div[@class='category-cards' and .//h5[text()='Elements']]");
    By lTexTables =By.xpath("//ul/li[.//span[text()='Web Tables']]");
  String url="https://demoqa.com";
    {
        // burasi instance initializer ,her new yaptigindan constructor dan hemen  önce calisir
        driver=getDriver();// constructor ile metodu cagirdik
        driver.manage().window().maximize();
    }

    /*
    *   https://demoqa.com/
        Elements linkine tiklayin
        Web Tables'a tiklayin
        Last Name'i Vega olan kaydi silin.
        Kaydin silindigini assert edin*/


    @Test
    public void senaryo1(){
        driver.get(url);

         scrollBy(500);//reklamdan yada baska sebepten clikc yapilamiyorsa bu kullanilabilir.500 br asagi iner
        driver.findElement(lElemts).click();




        driver.findElement(lTexTables).click();

        By lDeleteButton=getXPathOf("Vega",false);
        driver.findElement(lDeleteButton).click();
        sleep(500);

         //silme asserttion i icin 1.yol
        List<WebElement> buttons=driver.findElements(getXPathOf("Vega"));
        Assert.assertEquals(buttons.size(),0);

        //silme asserttion i icin 2.yol
        boolean isExists=false;
        try {
            driver.findElement(getXPathOf("Vega"));
            isExists=true;
        }catch (Exception e){
            Assert.assertFalse(isExists);
            sleep(3000);
            driver.quit();
        }

         /*
         * Tiklama islemi
         * 1-selenium click();
         * 2-selenium Actions() ile click
         * 3-javascript ile click*/
        //div.category-cards>div:first-child

        sleep(3000);
        driver.quit();

    }

    @Test
    public void testEdit(){
           driver.get(url);
           scrollBy(500);
           driver.findElement(lElemts).click();
           scrollBy(700);
           driver.findElement(lTexTables).click();
           driver.findElement(getXPathOf("Vega")).click();
           sleep(300);
           WebElement name=   driver.findElement(getXpathOfInput("First Name"));
           name.clear();
           name.sendKeys("New Name");
           driver.findElement(By.id("submit")).click();
           sleep(200);
           driver.findElement(getXPathOf("New Name"));
           sleep(5000);
        //   driver.quit();



    }
    public  By getXpathOfInput(String label){
        return By.xpath("//div[@class='modal-content']//label[contains(.,'"+label+"')]//ancestor::div[@id]//input");
        }

    public By getXPathOf(String name){
       return getXPathOf(name,true);

    }
    public By getXPathOf(String name,boolean edit){
        if (edit)
        return By.xpath("//div[text()='" + name + "']//parent::div//span[@title='Edit']");
        else
            return By.xpath("//div[text()='Vega']//parent::div//span[@title='Delete']");
    }
    public void scrollBy(int y){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+ y +")");
    }

    public WebDriver getDriver() {
        return getDriver("chrome");

    }
    public WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();
        }
    }
    public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
