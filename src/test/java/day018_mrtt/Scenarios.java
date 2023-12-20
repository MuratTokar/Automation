package day018_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;
import java.util.List;

public class Scenarios extends BaseTest {
    /*
    Contact Name : adinizi girin
        Register'a tiklayin
        Veri girilmeyen fieldlarda hata oldugunu assert edin

        Diger verileri doldurun
        Register'a tiklayin

        "Thank you for validating your ticket" ya da baska bir locator ile sonucu assert edin

     */

    {
        WebDriverWait wait;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    String url = "https://practice.expandtesting.com/form-validation";
    By ContackName = By.cssSelector("#validationCustom01");
    By ContackNumm = By.xpath("//input[@name='contactnumber']");
    By lSelect = By.xpath("//select");
    By lregister = By.cssSelector("button[class='btn btn-primary']");
    By lInvalid = By.cssSelector(".invalid-feedback");
    By date = By.cssSelector("input[name='pickupdate']");
    By payment = By.cssSelector("#validationCustom04");
    By option = By.cssSelector("option[value='card']");
    String str = "Thank you for validating your ticket";

    By lname=By.cssSelector("#firstName");
    By llastname=By.cssSelector("#lastName");
    By luseMail=By.cssSelector("#userEmail");
    By lgender=By.cssSelector("input[value='Male']");
    By lmobile=By.cssSelector("#userNumber");
    By ldate=By.cssSelector("#dateOfBirthInput");

    @Test
    public void test1() {
        driver.get(url);
        WebElement contackName = driver.findElement(ContackName);
        contackName.clear();
        contackName.sendKeys("Murat Tokar");

        WebElement Contack = driver.findElement(ContackNumm);
        Contack.clear();
        Contack.sendKeys("123-1234567");

        WebElement register = driver.findElement(lregister);
        register.click();


        List<WebElement> listt = driver.findElements(lInvalid);

        int count = 0;
        for (WebElement element : listt) {
            if (element.isDisplayed())
                count++;

        }

        Assert.assertEquals(count, 2);


        WebElement daten = driver.findElement(date);
        daten.sendKeys("11.09.2023");

        WebElement paymentt = driver.findElement(payment);
        //WebElement paymentt=driver.findElement(lSelect);
        // WebElement paymentt=wait.until(ExpectedConditions.visibilityOfElementLocated(lSelect));
        paymentt.click();
        //  Select dropD=new Select(paymentt);
        //  dropD.selectByIndex(1);
        WebElement options = driver.findElement(option);

        options.click();


        register.click();

        sleep(4000);
         driver.quit();


    }
    @Test
    public  void test2(){
        String url="https://demoqa.com/automation-practice-form";
        driver.get(url);
        ((JavascriptExecutor)driver).executeScript("document.body.style.zoom='50%'");

        WebElement name=driver.findElement(lname);
        name.sendKeys("Murat");


        WebElement SurName=driver.findElement(llastname);
        SurName.sendKeys("Tokar");

        WebElement email=driver.findElement(luseMail);
        email.sendKeys("muratttokar26@gmail.com");

        WebElement legender=driver.findElement(lgender);
        legender.click();


        WebElement tel=driver.findElement(lmobile);
        tel.sendKeys("7663325739",Keys.ENTER);

        WebElement date=driver.findElement(ldate);
        date.clear();
        date.sendKeys("13.09.2023", Keys.ENTER);














    }
}
