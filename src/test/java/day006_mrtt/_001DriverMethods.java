package day006_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _001DriverMethods {
    public static void main(String[] args) {

        //gidersoft sayfasina gidildi
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.samanyoluhaber.com/");

        try {
            Thread.sleep(1000);// java yi bekletiyoruz
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

}
