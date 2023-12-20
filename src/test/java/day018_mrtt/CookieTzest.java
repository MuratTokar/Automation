package day018_mrtt;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.Set;

public class CookieTzest extends BaseTest {

    {

        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));


    }




    @Test
    public void test_getCookies(){
        String url="https://bonigarcia.dev/selenium-webdriver-java/cookies.html";

        driver.get(url);
    // driver.manage().deleteAllCookies();// burda cookileri sildik
      Set<Cookie> cookies= driver.manage().getCookies();// cookies leri aldik
        for (Cookie cookie:cookies){
            System.out.println("cookie.getName() = " + cookie.getName());
            System.out.println("cookie.getValue() = " + cookie.getValue());
            /*
            * cookie.getName() = date
              cookie.getValue() = 10/07/2018
              cookie.getName() = username
              cookie.getValue() = John Doe*/

        }
        //cookie ekleme
       Cookie myCookie=new Cookie("text","selenium");
        //Cookie myCookie=new Cookie("text", RandomStringUtils.randomAlphabetic(10,20));// bu da random cookie ekleme

        driver.manage().addCookie(myCookie);
        System.out.println(driver.manage().getCookieNamed("text"));//text=selenium; path=/; domain=bonigarcia.dev;secure;; sameSite=Lax
        driver.quit();

    }
}


