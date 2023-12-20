package day010_mrtt;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

public class ButtonTest extends BaseTest {
    /*
     * http://uitestingplayground.com/textinput
     * inputbox a random bir text girin
     * Butona tiklayin
     * Butonun text inin girdiginiz text oldugunu assert edin
     * */
    String url = "http://uitestingplayground.com/textinput";
    By lInputlbox = By.cssSelector("#newButtonName");
    By lButton = By.cssSelector("#updatingButton");


    WebDriver driver = new ChromeDriver();

    String tex = RandomStringUtils.randomAlphabetic(5, 10);


    @Test
    public void buttonTest() {
        driver.get(url);
        driver.manage().window().maximize();
        driver.findElement(lInputlbox).sendKeys(tex);
        driver.findElement(lButton).click();
        Assert.assertEquals(driver.findElement(lButton).getText(), tex);

        sleep(1000);
        driver.quit();
    }

}
