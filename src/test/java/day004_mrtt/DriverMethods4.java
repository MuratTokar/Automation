package day004_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverMethods4 {
    static WebDriver driver;
    static String url = "https://www.saucedemo.com/";


    public static void main(String[] args) {
        driver = getDriver();
        sleep();
        driver.get(url);
        By luser=(By.id("user-name"));
        By lPass=By.name("password");
        By lLogin=By.id("login-button");

        WebElement username = driver.findElement(luser);
        username.sendKeys("standard_user");

        WebElement password = driver.findElement(lPass);
        password.sendKeys("secret_sauce");

        WebElement login = driver.findElement(lLogin);
        login.click();

        sleep(3000);

        driver.quit();//driveri rem den siler

    }


    public static WebDriver getDriver() {
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

    public static void sleep() { //default metot
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
