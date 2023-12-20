package day004_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverMethods3 {
    static WebDriver driver;
    static String url="https://www.saucedemo.com/";


    public static void main(String[] args) {
        driver=getDriver();
        sleep();
        driver.get(url);

        /* By locator class
        By.id();
        By.name();
        By.linkText();
        By.partialLinkText();
        By.className();
        By.cssSelector();
        By.xpath()
        */
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        sleep(3000);

        driver.quit();//driveri rem den siler

    }





    public static WebDriver getDriver (){
       return getDriver("chrome");
    }

public static WebDriver getDriver(String browser) {
    switch (browser.toLowerCase().trim()) {
        case "firefox":
            return new FirefoxDriver();

        case "edge":
            return new EdgeDriver();

        default:
            return new ChromeDriver();


    }


}
    public static void sleep(){ //default metot
        sleep(1000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
