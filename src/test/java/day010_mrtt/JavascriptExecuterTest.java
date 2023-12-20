package day010_mrtt;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

public class JavascriptExecuterTest extends BaseTest {
    /*
     * sayfada kaydirma islemler (scroll) JavaScriptExecuter ile yapilir
     * ScrollBy(x,y)=bulundugu yerden x kadar saga sola ,y kadar asagi yukari kaydir
     * ScrollTo(x,y)=x y noktasina git.statik bir noktaya gider
     * ScrollIntoView():belirtilen elemente kadar scrol eder
     * */
    String url = "https://bonigarcia.dev/selenium-webdriver-java/infinite-scroll.html";

    @Test
    public void text_scrollBy() {
        driver = Driver.getDriver();
        driver.get(url);

        for (int i = 0; i < 10; i++) {
            scrollBy(200);
            sleep(200);

        }
        for (int i = 0; i < 5; i++) {
            scrollBy(-200);
            sleep(200);
        }
        driver.quit();
    }

    @Test
    public void scrollBy2() {
        driver = Driver.getDriver();
        driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;     // scroll icin javascript kullanirirz
        js.executeScript("window.scrollBy(0,500)");   // kaydirma yaptik
        sleep(2000);
        driver.quit();


    }


    @Test
    public void scrollTo() {
        driver = Driver.getDriver();
        driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) driver;     // scroll icin javascript kullanirirz
        js.executeScript("window.scrollTo(100,500)");   // kaydirma yaptik
        sleep(2000);
        driver.quit();


    }

    @Test
    public void scrollTo2() {
        driver = Driver.getDriver();
        driver.get(url);

        for (int i = 0; i <5 ; i++) {
        scrollBy(200);
        sleep(300);
        }
        scrollTo(0);
        sleep(4000);
        driver.quit();
    }
    @Test
    // belirtilen elemente kadar gider
    public void test_ScrollIntoView(){
       WebDriver driver = Driver.getDriver();

        driver.get(url);
        By lElement=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        WebElement element=driver.findElement(lElement);
        // belirtilen elemente gider --
        // scrollIntoView(); veya  scrollIntoView(true); ise elementin ust kismini sayfanin ustune hizalar
        // scrollIntoView(false); ise  elementin alt kismini sayfanin altina hizalar
       //
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",element);
        sleep(5000);
        driver.quit();


    }
    @Test
    // belirtilen elemente kadar gider
    public void test_ScrollIntoView2(){
        driver = Driver.getDriver();

        driver.get(url);
        By lElement=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        WebElement element=driver.findElement(lElement);
         scrollIntoView(element,false);

        sleep(5000);
        driver.quit();


    }
    @Test
    public void test_ScrollIntoView3(){
        driver=Driver.getDriver("Chrome");
        driver.get(url);
        By lElement=By.xpath("//p[contains(text(),'Rutrum conubia')]");
        WebElement element=driver.findElement(lElement);
        scrollIntoView(element,false);
        sleep(1000);
        int y=driver.manage().window().getSize().getHeight()/2;
        System.out.println(y);
        scrollBy(y);
       sleep(5000);
       driver.quit();

    }
    @Test
    public void buttonClickWithJs() {
        String url = "http://uitestingplayground.com/textinput";
        By lInputlbox = By.cssSelector("#newButtonName");
        By lButton = By.cssSelector("#updatingButton");
        driver=Driver.getDriver();
        driver.get(url);
        String tex = RandomStringUtils.randomAlphabetic(5, 10);
        driver.findElement(lInputlbox).sendKeys(tex);
        driver.findElement(lButton).click();
        sleep(300);
        Assert.assertEquals(driver.findElement(lButton).getText(), tex);

        sleep(1000);
        driver.quit();
    }


}