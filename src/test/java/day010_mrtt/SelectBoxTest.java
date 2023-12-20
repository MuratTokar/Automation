package day010_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utils.Driver;
import utils.Utils;

public class SelectBoxTest {
    WebDriver driver= Driver.getDriver();
    // 1- https://the-internet.herokuapp.com/dropdown2-dropdown'un options.larinin textlerini consola yazdirin
    //2-  dropdown'un options.larinin textlerini consola yazdirin
    // 3- siradan tüm optionlari 1 sn ara vererek secin
    // 4- value degeri 1 olani secin
    // 5- visible texti Option 2 olani secin
    By lcssDropDown=By.cssSelector("#dropdown");
    String url= "https://the-internet.herokuapp.com/dropdown";


    @Test
    public void dropDown(){
        driver.get(url);
        Select dd=new Select(driver.findElement(lcssDropDown));
       // System.out.println(dd.getOptions()); optionlarin textlerini yazar

       // dd.selectByIndex(1);// 1.option
       // Utils.sleep(1000);
       // dd.selectByIndex(2);//2.option
       // Utils.sleep(1000);
       // dd.selectByValue("1");//value degeri 1 olan
        //Utils.sleep(1000);
        //dd.selectByVisibleText("Option 2");//visible texti Option 2 olani
        for(WebElement option:dd.getOptions()){
            System.out.println(option.getAttribute("value")+ ":" + option.getText());// value ve gettext
        }
        for (int i = 0; i < dd.getOptions().size(); i++) {
            if (dd.getOptions().get(i).getAttribute("disabled")==null)
                dd.selectByIndex(i); // indexine göre
            Utils.sleep(1000);

        }
        dd.selectByValue("1");// value
        Utils.sleep(1000);
        dd.selectByVisibleText("Option 2");// gozuken tex i
        Utils.sleep(1000);
        driver.quit();


    }


   // Inputbox'a random bir text girin
   // Butona tiklayin
   // Butonun texttinin girdiginiz text oldugunu assert edin

}