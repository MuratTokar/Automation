package day014_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class TestSwitch extends BaseTest {

    {
        driver= Driver.getDriver();



    }





    // Guidersoft sayfasinda footer da bulunan "courses" linkine tiklayin
    //acilan sayfada kurs basliklarini bir arraylist e atin
    // yahoo sayfasina geri dönün ve sayfayi kapatin
    //guidersoft sayfasina dönün
    // home linkine tiklayin,home sayfasina gittiginizi assert edin  ve driver i kapatin
    WebDriverWait wait;




    @Test
    public void test1(){
        String url=" https://yahoo.com";

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // https://yahoo.com sayfasina gidin
        driver.get(url);
        driver.manage().window().maximize();

        // cookieleri kabul edin
        By cooki=By.xpath("//button[text()='Alle akzeptieren']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(cooki)).click();


        //searchbox a "guidersoft" yazin ve aratin
        By searcbox=By.cssSelector("input[id='ybar-sbq']");
        WebElement element=driver.findElement(searcbox);
        element.sendKeys("Guidersoft");
       // sendkeys(searcbox,"guidersoft");// yada bu metot ile

        By submitbutton=By.cssSelector("button[id='ybar-search']");
        WebElement seacrh=driver.findElement(submitbutton);

        seacrh.click();

        By guiHome=By.xpath("(//h3//a[contains(text(), Guider Soft')])[1]");
       WebElement home=driver.findElement(guiHome);
        home.click();

        //By coueseLink=By.xpath("//li/a[@href=\"https://guidersoft.com/courses/\"]");
       // WebElement cours=driver.findElement(coueseLink);
       // cours.click();

       // sleep(5000);
       // driver.quit();





    }
}
