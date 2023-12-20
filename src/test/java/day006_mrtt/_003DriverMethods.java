package day006_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class _003DriverMethods {
   static WebDriver driver;

    public static void main(String[] args) {
        String url="https://guidersoft.com/";
        driver=getDriver("chrome");
        driver.get(url);

        // driver.getTitle(): aktif sayfanin title sini return eder
        String title=driver.getTitle();
        System.out.println(title);

        // sayfanin titlesinin "Home -Guder Soft" oldugunu assert(dogrulama) edin
        if (!title.equalsIgnoreCase(" Home-Guider Soft"))
            throw new AssertionError(" Baslik 'Home-Guider Soft' degil");// burda testi keser

        //driver.getPageSource() sayfa kaynak kodlarini (html ) verir
        System.out.println(driver.getPageSource());

        //driver.getCurrentUrl() o anki url yi verir
        System.out.println(driver.getCurrentUrl());

        //driver.getWindowHandle() aktif pencerenin id sini verir
        System.out.println(driver.getWindowHandle());

        //driver.getWindowHandles() aktif pencerelerin  id lerini verir
        System.out.println(driver.getWindowHandles());


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
