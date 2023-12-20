package day022_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class Selectable extends BaseTest {
    String url="https://jqueryui.com/selectable/#default";
    By lDisplayAsGrid=By.linkText("Display as grid");
    By liframe=By.xpath("//iframe[@class='demo-frame']");

@BeforeTest
    public void setuo() {
    driver = Driver.getDriver();
   // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
}
    @AfterTest
    public void afterTest(){
    sleep(3000);
    driver.quit();
    }

    @Test
    public void start(){
        driver.get(url);
        driver.findElement(lDisplayAsGrid).click();

      driver.switchTo().frame(0);
        sleep(5000);


    }
    @Test(dependsOnMethods = {"start"})
    public void testSelect(){
        new Actions(driver).keyDown(Keys.CONTROL)
                .click(num(1))
                .pause(150)
                .click(num(3))
                .pause(150)
                .click(num(5))
                .pause(150)
                .click(num(7))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }
    WebElement num(int num){
    return driver.findElement(By.xpath("//ol[@id='selectable']/li[text()='" + num + "']"));
    }
}
