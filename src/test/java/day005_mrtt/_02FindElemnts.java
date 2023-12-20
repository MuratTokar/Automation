package day005_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class _02FindElemnts extends BaseClas{
    String url="http://opencart.abstracta.us/";
    @Test
    public  void test_FindElements(){
        driver.get(url);
        //driver.FindElement(locator)
        //eger locator sayfada yok ise hata veriri
        //ayni locator li birden fazla elemnt varsa ilkini alir
        WebElement element=driver.findElement(By.tagName("H4")); // birden fazla ise ilkini alir
        System.out.println(element.getText());

       List<WebElement> elements=driver.findElements(By.tagName("H4")); //lis  halinde alir bize gonderir,eger listede yok
        System.out.println(elements.size());
        // ise hata vermez null doner
       click(By.tagName("H4"));
       sleep(2000);
       driver.quit();

    }
}
