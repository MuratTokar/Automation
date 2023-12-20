package day006_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _002DriverMethods {
   static WebDriver driver;
    public static void main(String[] args) {


      // driver tanimlandi
        driver=getDriver("edge"); // icine browser atamaliyim ki hangi browseri cagirsam o gelsin

        // samanyolu sitesine gidildi
        driver.get("http://www.samanyoluhaber.com/");

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

    public static void sleep(long milis){ // oweloading yaptim
        try {
            Thread.sleep(milis );// java yi bekletiyoruz
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}
