package notlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverManageMethodlari {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //1- driver.manage().window().getSize(); icinde oldugu syafanin pixel olarak ölculerini döndürür
        //   driver.manage().window().setSize(new Dimension(degerler)); set ilede degerleri degistiririz
        System.out.println("driver.manage().window().getSize() = " + driver.manage().window().getSize());

        //2- driver.manage().window().getPosition() icinde oldugu sayfanin pixel olarak konumunu döndürür
        //    driver.manage().window().setPosition(new point(yeni degerler)) set ile degerleri degsitirriz
        System.out.println("driver.manage().window().getPosition() = " + driver.manage().window().getPosition());

        //3- driver.manage().window().maximize() icinde oldugu sayfayi maximum eder
        //  driver.manage().window().minimize(); icinde oldugu sayfayi minimize eder
        driver.manage().window().maximize();

        //4 -icinde oldugu sayfayi fullscreen yapar
        driver.manage().window().fullscreen();

        //DRIVER:MANAGE TIMEOUTOS METOTLARI
        //====================================================================
        //----1-
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));// Driverin ne kadar bekleyecegini söyler
    }
}
