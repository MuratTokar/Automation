package day004_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverMethods2 {
    static WebDriver driver;


    public static void main(String[] args) {
        driver=getDriver();
        driver.get("https://guidersoft.com");

       //Aktif sayfanin title sini return eder
        String title=driver.getTitle();
        System.out.println(title);//Home - Guider Soft

       //sayfanin GuiderSoft oldugunu assert edin
        if (!title.equalsIgnoreCase("Home - Guider Soft"))
        throw new AssertionError("Baslik uymuyor");

        //sayfanin kaynak kodlarini basar
        driver.getPageSource();

        // o    anki url yi bastirir
        System.out.println(driver.getCurrentUrl());

        //aktif pencerenin id sini verir
        System.out.println(driver.getWindowHandle());

        //acik olan tum pencerelerin numaralarini verir
        System.out.println(driver.getWindowHandles());

        sleep(3000);

        //sleep();//default metot
        driver.quit();//driveri rem den siler
       // driver.close();// aktif olan pencereyi kapatir
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
