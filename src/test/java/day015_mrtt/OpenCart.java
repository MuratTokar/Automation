package day015_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;
import java.util.List;

public class OpenCart extends BaseTest {
    {
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(100));
        driver.manage().window().maximize();
        Actions actions;
    }
    @Test
    public void test1(){
        String url="http://opencart.abstracta.us/";
        driver.get(url);
        By lSearch=By.xpath("//input[@name='search']");
        WebElement search= driver.findElement(lSearch);
        new Actions(driver)
                .sendKeys(search,"Maa")
                .sendKeys(Keys.BACK_SPACE)
                .sendKeys("c")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        By lText=By.cssSelector(".caption>h4");
        List<WebElement> listtext=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(lText));
        listtext.forEach(e-> Assert.assertTrue(e.getText().toLowerCase().contains("Mac")));
        driver.quit();
    }
}
