package day005_mrtt;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class _001Driver {
    public static void main(String[] args) {

        //edge driver setup ediliyor
        //WebDriverManager.edgedriver().setup();
        WebDriverManager.chromedriver().setup();

        // EdgeDriver in bir instance sini create ediyoruz
        WebDriver driver = new EdgeDriver();

        //"https://google.com" adresine git diyoruz
        driver.get("https://google.com");

        // actigimiz driver i kapatmamiz lazim.Yoksa ram de cok yukler

        try {
            Thread.sleep(2000);  // sleep in ustune gelip tikladigimizda secenek cikacak ya try catch yada exception
            // firlatmak icin .cunku checkend exception oldugu icin  sorunu cozmeliyiz
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }
        driver.quit();
/*
        WebDriver driver1=new ChromeDriver();
        driver1.get("https://amazon.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver1.quit();
*/

    }
}