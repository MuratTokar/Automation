package day022_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseTest;

import java.time.Duration;

public class Ödev extends BaseTest {
    String url="https://demoqa.com/webtables";

    // sitedeki tabloya DataProvider ile 5 kayit ekleyin
    By ladd=By.cssSelector("#addNewRecordButton");
    By lFirstname=By.cssSelector("#firstName");
    By lLastName=By.cssSelector("#lastName");
    By lEmail=By.cssSelector("#userEmail");
    By lAge=By.cssSelector("#age");
    By lSalary=By.cssSelector("#salary");
    By lDepartment=By.cssSelector("#department");
    By lSubmit=By.cssSelector("#submit");
    By lDelet1=By.id("#delete-record-1");


    @BeforeTest
    public void setup(){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));


    }
    @AfterTest
    public void afterTest(){
sleep(3000);
       //driver.quit();
    }
    @Test(priority = 1)
    public void test1(){
        driver.get(url);
        delete(1);
        delete(2);
        delete(3);


    }
    @Test(dataProvider = "addData",dependsOnMethods = {"test1"})
    public void filltheList(String firstNmae,String lastName,String eMail,String age,String salary,String department){
        click(ladd);
        sleep(3000);
        sendkeys(lFirstname,firstNmae);
        sendkeys(lLastName,lastName);
        sendkeys(lEmail,eMail);
        sendkeys(lAge,age);
        sendkeys(lSalary,salary);
        sendkeys(lDepartment,department);
        click(lSubmit);
    }
    @DataProvider(name = "addData")
    Object[][] getdata(){
        return new Object[][]{
                {"Arda","Turan","a.turan@gmail.com","40","1000","Futbol"},
                {"Hakan","Sükür","h.sukur@gmail.com","45","1500","Futbol"},
                {"Emre","Belozoglu","a.belo@gmail.com","41","1100","Futbol"},
                {"Arif","Erdem","a.erdem@gmail.com","44","1200","Futbol"},
                {"Arda","Güler","a.guler@gmail.com","25","2000","Futbol"},

        };
    }
    public void delete(int num){
       driver.findElement(By.cssSelector("#delete-record-" +num+"")).click();
    }

}
