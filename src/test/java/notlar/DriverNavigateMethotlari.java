package notlar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverNavigateMethotlari {
    public static void main(String[] args) {
     // WebSiteleri arasinda dolasmak icin kullanilir
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        //1- driver.navigate().to(); =istenilen url ye gider .  driver.get(url); ile ayni isi yapar ama geri sayfa
        // ve ileri sayfaya gitme imkani sunar
        driver.get("http://opencart.abstracta.us");
        driver.navigate().to("https://www.amazon.com");

        //2-driver.navigate().back();= bir onceki sayfaya döner
        driver.navigate().back();

        //3-  driver.navigate().forward();=bir sonraki sayfaya gider
        driver.navigate().forward();

        //4- driver.navigate().refresh(); =sayfayi yebiler
        driver.navigate().refresh();

        //5-  driver.close(); driver olusturldugunda acilan sayfayi kapatir
        driver.close();

        //6-  driver.quit(); driver calisirken birden fazla tab veya window actiysa tümünü  kapatir
        driver.quit();



/*
        document.addEventListener('keydown', function (e) {
            if (e.keyCode == 119) { // F8
                debugger;
            }
        }, {
            capture: true
        });


        */

    }



}
