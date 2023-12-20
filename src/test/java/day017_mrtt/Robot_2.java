package day017_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class Robot_2 extends BaseTest {

    {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    String url="https://the-internet.herokuapp.com";
    By lXpath=By.linkText("Basic Auth");


    @Test
    public void testt() throws AWTException {
        driver.get(url);
        driver.findElement(lXpath).click();
        wait.until(ExpectedConditions.urlContains("basic_auth"));
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('d'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('m'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('i'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('n'));

        robot.keyPress(KeyEvent.VK_TAB);
        sleep(2000);

        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('a'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('d'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('m'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('i'));
        robot.keyPress(KeyEvent.getExtendedKeyCodeForChar('n'));
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Basic Auth']")));

        sleep(3000);
        driver.quit();



    }

}
