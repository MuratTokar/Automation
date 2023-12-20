package day012_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.Utils;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class ImlicitlyWait5 {
    /*
     * Remove butonuna tikla checkbox'in invisible oldugunu assert et.
     *"Add" butonuna tikla  checkbox'in visible oldugunu assert et.
     *Enable butonuna tikla inputbox'in enable olmasini bekle
     *Disable butonuna tikla inputbox'in disable olmasini bekle*/
    WebDriver driver;


    @Test
    public void test() {
        String url = "https://demoqa.com/selectable";
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5), Duration.ofMillis(300));
        By labels = By.cssSelector("ul[id='verticalListContainer'] li");
        By lRandomFoundLabel = By.cssSelector("mt-2 list-group-item active list-group-item-action");
        driver.get(url);
        List<WebElement> listElements = driver.findElements(labels);
        listElements.get(new Random().nextInt(4)).click();
        listElements = driver.findElements(labels);
        //  List<WebElement> randomlabel = driver.findElements(lRandomFoundLabel);
        List<WebElement> randomlabel = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(labels));
        listElements.forEach(e -> System.out.println(e.getAttribute("background-color")));

        Utils.sleep(4000);

        driver.quit();


    }

    @Test
    public void clickButtons() {
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By lButton1 = By.cssSelector("#button00");
        By lButton2 = By.cssSelector("#button01");
        By lButton3 = By.cssSelector("#button02");
        By lButton4 = By.cssSelector("#button03");
        String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";


        driver.get(url);


        Utils.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(lButton1)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lButton2)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lButton3)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lButton4)).click();
        Utils.sleep(5000);
        driver.quit();


    }

    @Test
    public void clickButtons_2yol() {
        String url = "https://testpages.herokuapp.com/styled/dynamic-buttons-simple.html";

        driver = new ChromeDriver();
        driver.get(url);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        By[] locators = {
        By.cssSelector("#button00"),
        By.cssSelector("#button01"),
        By.cssSelector("#button02"),
        By.cssSelector("#button03")
       };

        for (int i = 0; i <locators.length ; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(locators[i])).click();

        }
        Utils.sleep(3000);
        driver.quit();


    }

}