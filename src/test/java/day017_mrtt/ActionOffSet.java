package day017_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ActionOffSet extends BaseTest {

    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    String url="https://www.snapdeal.com/product/hmct-615-metal-analog-mens/652415109752#bcrumbSearch:watch";
    By cssSel=By.cssSelector("ul#bx-slider-left-image-panel img:nth-of-type(1)");
    By accept=By.xpath("//div[text()='Alle zulassen']");
    @Test
    public void testOffset(){
        driver.get(url);

        new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(accept)).click();// cookie butonu aktif olana kadar bekledi ve tikladi
        wait.until(ExpectedConditions.invisibilityOfElementLocated(accept));// kapandigindan emin olana kadar bekle
         // action class sinda
        //moveToElement(element) ->0 elementin orta noktasina gider
        //moveToElement(element ,xOffSet,yOffSet) -> 0 elementin  x,y koordinatlarina gider
        WebElement saat=driver.findElement(cssSel);
        new Actions(driver).moveToElement(saat).perform();
        sleep(2000);
        move(saat,-100,-100);

        sleep(2000);
        move(saat,100,100);

        sleep(2000);
        move(saat,100,-100);

        sleep(2000);
        move(saat,-100,100);

        sleep(2000);

        driver.quit();

    }

    public void move(WebElement element,int x,int y){
        new Actions(driver).moveToElement(element, x, y).perform();
    }


    @Test
    public void testOffset1(){
        driver.get(url);


        wait.until(ExpectedConditions.visibilityOfElementLocated(accept)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(accept));

        WebElement saat=driver.findElement(cssSel);
        int with=saat.getSize().getWidth();
        int height=saat.getSize().getHeight();
        int x=with/2;
        int y=height/2;
        for (int i = 0; i < 100; i+=10) {
            move(saat,-x,-y);
            move(saat,-x+10,-y+10);
            move(saat,-x+20,-y+20);
            sleep(500);

        }



        driver.quit();

    }


    }


