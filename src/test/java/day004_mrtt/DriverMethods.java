package day004_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class DriverMethods {
    public static void main(String[] args) {


    WebDriver driver = new ChromeDriver();
    driver.get("https://guidersoft.com"  );
    driver.quit();
    }
}
