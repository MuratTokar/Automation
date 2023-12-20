package day015_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class DragDrop extends BaseTest {
    {
        driver= Driver.getDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public  void draDrop(){
        String url="https://demoqa.com/auto-complete";

        driver.get(url);
        By lMultiple=By.xpath("//div[@class=\"auto-complete__value-container auto-complete__value-container--is-multi css-1hwfws3\"]");
        WebElement multi=driver.findElement(lMultiple);
        new Actions(driver)
                .click(multi)
                .pause(500)
                .keyDown(Keys.SHIFT)
                .pause(500)
                .keyDown("G")
                .pause(500)
                .keyUp(Keys.SHIFT)
                .pause(500)
                .keyDown(Keys.ARROW_DOWN)
                .pause(500)
                .sendKeys(Keys.ENTER)
                .pause(500)
                .build()
                .perform();
    }
}
