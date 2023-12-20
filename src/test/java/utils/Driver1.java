package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver1 {
    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
    //her bir thread icin bier webdriver olusturacak.her thread icin ayri ayri tanimlar

    public static WebDriver getDrivers() {// eger parametre girmesem default deger return edecek
        return getDriver("Chrome");
    }

    public static WebDriver getDriver(String browser) {
        if (drivers.get() == null) {

            switch (browser.toLowerCase()) {
                case "edge":
                    drivers.set(new EdgeDriver());
                    break;
                case "firefox":
                    drivers.set(new FirefoxDriver());
                    break;
                default:
                    drivers.set( new ChromeDriver());
            }
        }
        return drivers.get();
    }
    public static void quit(){
        if (drivers.get()!=null){
            drivers.get().quit();
            drivers.set(null);
        }
    }
}