package day011_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Wait{
    WebDriver driver;
    String url="https://www.selenium.dev/selenium/web/dynamic.html";
    @Test
    public void test_getRectColor(){
        By lButton=By.cssSelector("input#adder");
        By lColor=By.cssSelector("#box0");
        /*
        * https://www.selenium.dev/selenium/web/dynamic.html
        * "Add a box! butonuna tikla ve cikan karenin rengini consola yazdir
        * */



        driver=new ChromeDriver();
        // -implicitly wait
        //  * Driver bünyesindedir.Bu bekleme element precence oluncaya kadar her element icin beklenir
        // precence=var oluncaya kadar.Kodlarda olan element presence dir

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        driver.findElement(lButton).click();
        //click ten sonra lcolor bir sure gecikmeli geliyor. burada thread.sleep(1000); konursa sorun cozulur
        // ama kesinlikle tavsiye edilmez,javanin akisini sistemi durdurur
       // sleep(1000);
        System.out.println(driver.findElement(lColor).getCssValue("background-color"));
        System.out.println(driver.findElement(lColor).isDisplayed());
        // sleep(2000);
        driver.quit();
    }


        @Test
        public void test_ExplicitlyWaitDegil1(){
            String url="https://www.selenium.dev/selenium/web/dynamic.html";
            By lRevealButton=By.cssSelector("#reveal");
            By lRevealInput=By.cssSelector("#revealed");
            /*
             * https://www.selenium.dev/selenium/web/dynamic.html
             * ""Reveal a new imput" butonuna tikla ve adini yazdir
             * */

            driver=new ChromeDriver();

           // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);
            driver.findElement(lRevealButton).click();
            driver.findElement(lRevealInput).sendKeys("Murat");

           // sleep(2000);
            driver.quit();
        }
    @Test
    public void test_ExplicitlyWait2(){
        String url="https://www.selenium.dev/selenium/web/dynamic.html";
        By lRevealButton=By.cssSelector("#reveal");
        By lRevealInput=By.cssSelector("#revealed");

        /*
         * https://www.selenium.dev/selenium/web/dynamic.html
         * ""Reveal a new imput" butonuna tikla ve adini yazdir
         * */
        driver=new ChromeDriver();
        //Wait :Explicitly wait olarak tanimlandi.Bekleme suresi 10 sn
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
         // bekleme suresi 20 sn.Her 300 ms bir elementin istenen sarta uygun olup olmadigini kontrol eder
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20),Duration.ofMillis(300));

        driver.get(url);

        driver.findElement(lRevealButton).click();
       WebElement input= wait.until(ExpectedConditions.visibilityOfElementLocated(lRevealButton));
       input.sendKeys("Murat");
       // driver.findElement(lRevealInput).sendKeys("Murat");buna gerek kalmadi
       // istedigimiz kadar wait acariz hem saniye ,hem milisaniye ekleriz
        // burada hata olustu.Element kodlarda var.WebDriver elementi buluyor.ama sendKeys yapamiyor

        /*
        * ExplicitWait: Eelemnte ozel islemleri gerceklestirir.visiable olmasini ,prencense olmasini,
        * renginin degismesini,invisiable olmasini,element saiyini
        * */


        driver.quit();
    }
    @Test
    public void test_ExplicitlyWait3() {

        String url1 = "https://bonigarcia.dev/selenium-webdriver-java/loading-images.html";
        driver=new ChromeDriver();

        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
        driver.get(url1);

        By lSpinner=By.cssSelector("#image-container img");

        wait.until(ExpectedConditions.visibilityOfElementLocated(lSpinner));
       List<WebElement> images= wait.until(ExpectedConditions.numberOfElementsToBe(lSpinner,4)); //spinner elementi sayisi 4 oluncaya kadara bekle
       //                                                           list return eder
       for(WebElement element:images){
           System.out.println(element.getAttribute("alt"));
       }

        sleep(5000);
        driver.quit();

    }





        public void sleep(long milis){
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void test_Explicitwait4(){
/*
       1- Remove butonuna tikla
             checkbox'in invisible oldugunu assert et.
       2-"Add" butonuna tikla
            checkbox'in visible oldugunu assert et.

       3- Enable butonuna tikla
             inputbox'in enable olmasini bekle

       4- Disable butonuna tikla
        inputbox'in disable olmasini bekle
        */

        By lButton=By.xpath("//button[text()='Remove']");
        By lCheckBox=By.xpath("//button[text()='Add']");
        By lEnableButton=By.xpath("//button[text()='Enable']");
        By lIsenable=By.xpath("//button[text()='Disable']");
        By lDisable=By.xpath("//button[text()='Disable']");
        By lEnable=By.xpath("//button[text()='Enable']");




        String url="https://the-internet.herokuapp.com/dynamic_controls";
        driver=new ChromeDriver();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10),Duration.ofMillis(300));

        driver.get(url);
        WebElement clickRemove=driver.findElement(lButton);
        clickRemove.click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(lCheckBox));
        sleep(5000);


        WebElement add=driver.findElement(lCheckBox);
        add.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lButton));
        sleep(5000);

        WebElement enable=driver.findElement(lEnableButton);
        enable.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lIsenable));
        sleep(5000);

        WebElement disable=driver.findElement(lDisable);
        disable.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lEnable));



        sleep(5000);
        driver.quit();




    }
}



