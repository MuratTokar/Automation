package day006_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class _008Odev {
   static WebDriver driver;
   static String url=("https://www.saucedemo.com/");


@Test
    public static void test1(){
        driver =getDriver();
        driver.get(url);

        //username id ile bulduk ve "standard_user" degerini yazdik
        By lUsername=By.id("user-name");
        WebElement username=driver.findElement(lUsername);
        username.sendKeys("standard_user");

        // password imputunu name ile bulduk  ve "secret_sauce" degerini yazdik
        By lpassword=By.name("password");
        WebElement password=  driver.findElement(lpassword);
        password.sendKeys("secret_sauce");

        // login butonunu bulup tikladik
        WebElement loginButton= driver.findElement(By.id("login-button"));
        loginButton.click();

        // urunu bulup spete ekledik
        WebElement addToCart=driver.findElement(By.name("add-to-cart-sauce-labs-bike-light"));
        addToCart.click();

        //4.urunun eklendigini assert et(dogrula)
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());

        // sepete gidildi
        WebElement shoping=driver.findElement(By.id("shopping_cart_container"));
        shoping.click();

       //sepette ""Sauce Labs Bike Light"" urununun oldugunu assert et
       Assert.assertTrue(driver.getCurrentUrl().equalsIgnoreCase("https://www.saucedemo.com/cart.html"));
       Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-bike-light")).isDisplayed());

        sleep(3000);
        driver.quit();


    }









    public static WebDriver getDriver(){
        return getDriver("chrome");

    }
    public static WebDriver getDriver(String browser){
        switch (browser.toLowerCase().trim()){
            case "edge":
                return new EdgeDriver();
            case "firefox":
                return new FirefoxDriver();
            default:
                return new ChromeDriver();

        }
    }




    public static void sleep(){
        sleep(1000);
    }
    public static void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }

}

