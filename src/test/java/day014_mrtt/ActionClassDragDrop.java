package day014_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ActionClassDragDrop extends BaseTest {
    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));


    }

    WebDriverWait wait;

    Actions actions;

    @Test
    public void drogDrop1() {
        String url = "https://testpages.herokuapp.com/styled/drag-drop-javascript.html";
        driver.get(url);
        WebElement dragable1 = driver.findElement(By.xpath("//div[@id='draggable1']"));
        WebElement droppable1 = driver.findElement(By.xpath("//div[@id='droppable1']"));
         new Actions(driver)
         .dragAndDrop(dragable1, droppable1).perform();
/*              Farkli bir yol
                 new Actions(driver)
                .clickAndHold(dragable1)//1 .olani tut
                .moveToElement(droppable1)//1 hedefin uzerinde tut
                .release()//maus u birak
                .perform();// islemi yap*/
        driver.quit();
    }

    @Test
    public void drogDrop2() {

        String url = "https://practice.expandtesting.com/drag-and-drop-circles";
        driver.get(url);
        WebElement drop = driver.findElement(By.xpath("//div[@class='span-6 dragTarg']"));
        WebElement drag1 = driver.findElement(By.xpath("//div[@class='red']"));
        WebElement drag2 = driver.findElement(By.xpath("//div[@class='green']"));
        WebElement drag3 = driver.findElement(By.xpath("//div[@class='blue']"));
        new Actions(driver)
                .clickAndHold(drag1)
                .pause(200)
                .moveToElement(drop)
                .pause(200)
                .release()
                .build()
                .perform();

        driver.quit();

    }


}

