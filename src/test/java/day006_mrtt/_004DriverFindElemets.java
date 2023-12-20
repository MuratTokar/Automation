package day006_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _004DriverFindElemets {
   static WebDriver driver;
   static String url="https://www.saucedemo.com/";

    public static void main(String[] args) {
        driver=getDriver("edge");
        driver.get(url);

/*   By locator class idir
        By.id();
        By.name();
        By.linkText();
        By.partialLinkText()
*/
        // username input unu id ile bulduk  ve "standard_user" degerini yazdik
       driver.findElement(By.id("user-name")).sendKeys("standard_user");

       // password u name ile bulduk ve "secret_sauce" degerini yazdik
       driver.findElement(By.name("password")).sendKeys("secret_sauce");

         //login butonunu bulduk ve click ettik
       driver.findElement(By.id("login-button")).click();

        sleep();
        driver.quit();

    }
    public static WebDriver getDriver(){
        return getDriver("chrome");
    }

    public static WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){

            case "edge":
                return new EdgeDriver();

            case "firefox":
                return new FirefoxDriver();

            default:
                return new ChromeDriver();

        }

    }
    public static void sleep(){ // default deger atadim
        sleep(1000);
    }

    public static void sleep(long millis){ // oweloading yaptim
        try {
            Thread.sleep(1000 );// java yi bekletiyoruz
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
