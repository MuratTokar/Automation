package day010_mrtt;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Driver;
import utils.Utils;

import java.util.List;

public class CheckBoxTest {
    public static void main(String[] args) {





        WebDriver driver = Driver.getDriver();
        String url = "https://the-internet.herokuapp.com/checkboxes";
        By lCheckBoxes = By.cssSelector("#checkboxes input");// id si checkbox olan input tu aradik
        // By lCheckboxes=By.cssSelector("input[type='checkbox']");
        //  By lCheckboxes=By.xpath("//input[@type='checkbox']");

        // 1-https://the-internet.herokuapp.com/checkboxes
        driver.get(url);


        // 2-her iki checkbox'in valuesunu consola yazdirin
        List<WebElement> cbs = driver.findElements(lCheckBoxes);
        for (WebElement cb : cbs) {
            System.out.println(cb.getAttribute("checked"));// null true // checked olan True ,checked olmayan null


        } // 3-tikli olmayani tiklatin
        for (WebElement cb : cbs) {
            if (cb.getAttribute("checked")=="null");
                cb.click();


        }   // 4-her iki checkbox'in valuesunu consola yazdirin
        for (WebElement cb : cbs) {
            System.out.println(cb.getAttribute("checked"));
        }


            Utils.sleep(4000);
            driver.quit();


        }
    }




