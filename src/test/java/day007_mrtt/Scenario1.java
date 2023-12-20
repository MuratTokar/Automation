package day007_mrtt;

import day005_mrtt.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;



public class Scenario1 extends BaseClas {

    /* Elements linkine tiklayin
    Text Box'a tiklayin
    Acilan formu doldurun
    Submit butonuna tiklayin
    Girdiginiz verilerin fomun alt kisminda ciktigini dogrulayin*/

    String fullName="Murat Tokar";
    String fullMail="murattokar26@gamil.com";
    String url="https://demoqa.com/text-box";
    String C_Adress="Prinzenstrasse 10";
    String P_Adress="Friedrichstrasse 20";

    By lUsername=By.cssSelector("#userName");
    By lMail=By.cssSelector("#userEmail");
    By lCurAdress=By.xpath("(//textarea)[1]");
    By lPer_Address= By.xpath("(//textarea)[2]");
    By lbutton= By.cssSelector("button#submit");

    WebElement userName=driver.findElement(lUsername);
    WebElement userMail=driver.findElement(lMail);
    WebElement currAdres= driver.findElement(lCurAdress);
    WebElement perAdres=driver.findElement(lPer_Address);
    WebElement button= driver.findElement(lbutton);



    @Test
    public void test1Demoqa(){

          driver.get(url); // texBox a gidildi
          driver.manage().window().maximize();
          userName.sendKeys(fullName); // user name gondrildi
          userMail.sendKeys(fullMail);// eMail gonderildi
          currAdres.sendKeys(C_Adress);// curAdress gondrildi
          perAdres.sendKeys(P_Adress);// parmanentAdress gonderildi
          button.click();//submit tiklandi
          Assert.assertTrue(driver.findElement(By.cssSelector("p#name")).getText().contains(fullName));
          sleep(1000);
          driver.quit();

/*
        sendkeys(lUsername,fullName);
        sendkeys(lMail,fullMail);
        sendkeys(lCurAdress,C_Adress);
        sendkeys(lPer_Address,P_Adress);
        Assert.assertTrue(driver.findElement(By.cssSelector("p#name")).getText().contains(fullName));
        click(lbutton);
        driver.quit();*/
    }
}
