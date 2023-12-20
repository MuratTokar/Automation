package day020_mrtt;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasDemoqa {
    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demoqa.com/text-box";

    @FindBy(css = "#userName")
    WebElement eUsername;
    //WebElement username= driver.findElement(By.cssSelector("#userName")); bu islem yukarida yapildi

    @FindBy(css = "#userEmail")
    WebElement eUsermail;

    @FindBy(css = "#currentAddress")
    WebElement eCurrentAdres;

    @FindBy(css = "#permanentAddress")
    WebElement eFermanentAdress;

    @FindBy(css = "#submit")
    WebElement eSubmit;

    public BasDemoqa(WebDriver driver) { // disardan driver alacak
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void getUrl() {
        driver.get(url);
    }

    public void sendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);


    }

    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollBy(int y) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0," + y + ")");

    }
}
