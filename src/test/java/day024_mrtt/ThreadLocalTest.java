package day024_mrtt;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThreadLocalTest {
    public static WebDriver driver;

    public static ThreadLocal<WebDriver> drivers=new ThreadLocal<>();

    public void getStaticDriver(){
        driver=new ChromeDriver();
        drivers.set(new ChromeDriver());
        drivers.get();



    }



}