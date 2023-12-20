package day014_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class ActionsClassMoveToElement extends BaseTest {

    {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    WebDriverWait wait;

    @Test
    public void actionClass1() {
        String url = "http://opencart.abstracta.us/";
        driver.get(url);
        By lDesktops = By.xpath("//a[text()='Desktops']");
        WebElement element = driver.findElement(lDesktops);
        Actions actions = new Actions(driver);// actions ttanimladik
        actions.moveToElement(element)
                .pause(100)
                .build()// yukarida siralanan islemleri insa et
                .perform();// islemleri uygula//bu kod desktops un uzerine gidecek bekleyecek.Maus ile yaptigimiz gibi.
        // hover yapar yani ustune gelir


    }

    @Test
    public void actionClass2() {
        String url = "http://opencart.abstracta.us/";
        driver.get(url);
        By lDesktops = By.xpath("//ul[@class='nav navbar-nav']/li");
        List<WebElement> desklist = driver.findElements(lDesktops);
       /* desklist.forEach(e -> {
            new Actions(driver).moveToElement(e).pause(100).perform();

        });*/

        for (WebElement menu : desklist) { // ya da for ile
            new Actions(driver).moveToElement(menu).pause(200).perform(); // bu sekilde yan yana olan menulerin tek tek uzerine gitti
            By subList = By.xpath(".//ul/li");
            List<WebElement> list = driver.findElements(subList);
            if (list.size() > 0) { // boylede her menu nun altindaki menuleri gorduk
                for (WebElement submenu : list) {
                    new Actions(driver).moveToElement(submenu).pause(100).perform();
                }
            }
        }
        driver.quit();


    }
    @Test
    public void testActionClass4(){
        String url="https://bonigarcia.dev/selenium-webdriver-java/mouse-over.html";
        driver.get(url);
        By lover=By.xpath("//div[@class='figure text-center col-3 py-2']//img[@class='img-fluid']");

    }


}
