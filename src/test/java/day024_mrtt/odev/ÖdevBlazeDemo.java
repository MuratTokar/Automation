package day024_mrtt.odev;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Driver;

import java.time.Duration;

public class ÖdevBlazeDemo {
    WebDriver driver;
    WebDriverWait wait;
    public String url="https://demoblaze.com";
    By lContactLink=By.linkText("Contact");
    By lMessageDiaolog=By.xpath("//div[@class='modal-dialog' and .//*[text()='New message']]");
    By LContactMail=By.id("recipient-email");
    By LContactName=By.id("recipient-name");
    By LContactMessage=By.id("message-text");
    By lClose=By.xpath(".//button[text()='Close']");
    By lSendMessage=By.xpath(".//button[text()='Send message']");
    String alerttest="Thanks for the message";

    @BeforeTest
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser){
        driver= Driver.getDriver(browser);
        driver.manage().window().setSize(new Dimension(500,700));
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));

    }
    @AfterTest
    public void tearDown(){
        driver.quit();

    }
    @Test
    public void getSite(){
        driver.get(url);
        wait.until(ExpectedConditions.titleContains("STORE"));
    }
    @Test(dependsOnMethods = {"getSite"})
    @Parameters({"contactEmail","contactNmae","messageText"})
    public void message(String contactEmail,String contactName,String messageText ){
        click(lContactLink);
        WebElement dialog=wait.until(ExpectedConditions.visibilityOfElementLocated(lMessageDiaolog));
        sendkeys(LContactMail,contactEmail);
        sendkeys(LContactName,contactName);
        sendkeys(LContactMessage,messageText);
        click(lSendMessage);
        Alert alert=wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lMessageDiaolog));

    }

    public void click(By locator){
        driver.findElement(locator).click();
    }
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void sendkeys(By locator,CharSequence text){
        WebElement element=driver.findElement(locator);
        element.sendKeys(text);
    }

}
