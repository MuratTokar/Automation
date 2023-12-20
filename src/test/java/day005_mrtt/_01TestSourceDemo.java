package day005_mrtt;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01TestSourceDemo extends BaseClas {
    //WebDriver driver; // burda once kendi class inda  arayacak ama

    // burda tanimlamadigim icin nullpointer verecek .silersem parentclass tan
    // alacak.Parent e tanimladigimiz icin subclass ta gerek yok tanimlamaya
    //super.getDriver("https://google.com"); super ile de cagirabilirim


    By lUsername = By.id("user-name");
    By lPassword = By.id("password");
    By lLoginButton = By.id("login-button");
    By lUrunAddToCart = By.id("add-to-cart-sauce-labs-bike-light");
    By lUrunRemove=By.id("remove-sauce-labs-bike-light");
    By lCart=By.id("shopping_cart_container");



    String loginUsername = "standard_user";
    String loginpassword = "secret_sauce";

    @Test
    public void test_login1() {


        //1."https://www.saucedemo.com/" sitesine git
        String url = "https://www.saucedemo.com/";
       driver.get(url);

        //2.login ol
        // find:username->clear et,send:"standard_user"
        // find:password->clear et send:"secret_sauce"
        WebElement eUsername = driver.findElement(lUsername);
        eUsername.clear();
        eUsername.sendKeys(loginUsername);

        WebElement ePassword = driver.findElement(lPassword);
        ePassword.clear();
        eUsername.sendKeys(loginpassword);

        driver.findElement(lLoginButton).click();


        //3."sauce Labs Bike Light" urununu sepete ekle
        //ürün div i icindeki ilgili Add to Cart butonuna tikla (id veya name)

        //4.ürünün eklendigini assert et
        // tiklanan Add to Cart butonunun text i Remove oldu mu
        //5.sepete git
        //6.Sepette "sauce Labs Bike Light" urununun oldugunu assert et

        sleep(1000);
        driver.quit();

    }

    @Test
    public void test_login2() {


        //1."https://www.saucedemo.com/" sitesine git
        String url = "https://www.saucedemo.com/";
        driver.get(url);

        //driver.manage().window().maximize();// once acar sonra ekrani buyutur
        driver.manage().window().setPosition(new Point(100,10));// browser in sol ust kosesinin koordinati ayarlandi

        driver.manage().window().setSize(new Dimension(500,700));// browswerin genisligi ve yuksekligi ayarlandi


        //2.login ol
        // find:username->clear et,send:"standard_user"
        // find:password->clear et send:"secret_sauce"
        sendkeys(lUsername, loginUsername); // metodu cagirdim
        sendkeys(lPassword, loginpassword);
        click(lLoginButton);
        // driver.findElement(lLoginButton).click(); // parent class atarsak iyi olur
        //3."sauce Labs Bike Light" urununu sepete ekle
        click(lUrunAddToCart);

        //ürün div i icindeki ilgili Add to Cart butonuna tikla (id veya name)

        //4.ürünün eklendigini assert et----isDisplayed=urun goruldu mu
        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());

        // tiklanan Add to Cart butonunun text i Remove oldu mu
        //5.sepete git
        click(lCart);
        //6.Sepette "sauce Labs Bike Light" urununun oldugunu assert et
        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());

        sleep(1000);
        driver.quit();
    }

    @Test
    public void test_sendKey() {

        String url = "https://www.saucedemo.com/";
        driver.get(url);

        sendkeys(lUsername, loginUsername);
        sendkeys(lPassword, loginpassword, Keys.ENTER);// sifreyi girince Enter yap

        click(lUrunAddToCart);
        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());
       // click(lLoginButton);
        click(lCart);//sepete gitti

        //urun sepette mi
        Assert.assertTrue(driver.findElement(lUrunRemove).isDisplayed());

        sleep(1000);
     driver.quit();


    }
}