package notlar;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverGetMethodlari {
    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();// önce chrome nin set-up unu kurduk
        WebDriver driver=new ChromeDriver();// WebDrive objesini olusturduk

          //1-driver.get(url);//=yazilan adrese gider
          driver.get("http://opencart.abstracta.us");

          //2-  driver.getTitle())=// sitenin basligini getirir
          System.out.println("driver.getTitle() = " + driver.getTitle());

          //3-driver.getCurrentUrl()= icinde oldugu sayfanin URL sini döndürür
          System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

          //4-driver.getPageSource()=sayfanin kaynak kodunu verir
          System.out.println("driver.getPageSource() = " + driver.getPageSource());

          //5-driver.getPageSource()=icinde oldugu sayfanin UNIQUE hash kodunu verir
          System.out.println("driver.getPageSource() = " + driver.getWindowHandle());

          //6-driver.getPageSource()=Driver calisirken acilan tum sayfalarin UNIQUE hash kodunu verir
          System.out.println("driver.getWindowHandles() = " + driver.getWindowHandles());


    }
}
