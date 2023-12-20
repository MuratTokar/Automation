package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {// eger parametre girmesem default deger return edecek
        return getDriver("Chrome");
    }
// test1 claass in da driver olarak chrome cagirdigimda ustte deger null oldugu icin
// chrome tanimlayacak ve bana gonderecek.Ikinciye edge driver
// cagirirsam bakacak degeri artik nul degil yine chrome gelecek.ilk ne tanimlandiysa oyle olacak
    //paralelde olsa tek bir driver tanimliyoruz
    public static WebDriver getDriver(String browser) {
        if (driver == null) {

            switch (browser.toLowerCase()) {
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        }
        return driver;
    }
    public static void quit(){
        if (driver!=null){ // null degilse kapat
            driver.quit();
            driver=null;  // degeri tekrar null yap .ikinci browseri kullanmak icin
        }
    }
}