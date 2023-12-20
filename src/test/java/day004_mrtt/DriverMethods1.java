package day004_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverMethods1 {
    static WebDriver driver;


    public static void main(String[] args) {
        driver=getDriver();
        driver.get("https://guidersoft.com");
      sleep(3000);
        //sleep();//default metot
        driver.quit();
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
