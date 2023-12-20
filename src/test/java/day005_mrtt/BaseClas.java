package day005_mrtt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClas {
   public WebDriver driver; // bu diger class ta super ilede cagrilabilirdi
    public BaseClas(){ // constructor olusturduk
        driver=getDriver("chrome");
    }
    public void maximize(){
        driver.manage().window().maximize();
    }
    public  WebDriver getDriver() {
        return getDriver("chrome");
    }

    public WebDriver getDriver(String browser) {
        switch (browser.toLowerCase().trim()) {

            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                return new ChromeDriver(options);
        }
    }
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
    public void click(By locator){
        driver.findElement(locator).click();

    }
    public void sendkeys(By locator,CharSequence...text){
        WebElement eUsername = driver.findElement(locator);
        eUsername.clear();
        eUsername.sendKeys(text);
    }
    //driver.findElement(By.cssSelector("#userName")).sendKeys("Murat Tokar");


    public void scrollBy(int y){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,"+ y +")");
    }


}