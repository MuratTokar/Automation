package day005_mrtt;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03Odev extends BaseClas {






    @Test
    public void odev3(){
        driver.manage().window().maximize();
        String url="http://opencart.abstracta.us";
        //1 -http://opencart.abstracta.us/
        driver.get(url);

        // 2-"imac" search edin
        sendkeys(By.name("search"),"imac", Keys.ENTER);

         // 3-imac ürününün sayfaya geldigini assert edin.
        Assert.assertTrue(driver.findElement(By.tagName("H4")).getText().equalsIgnoreCase("imac"));

      // List<WebElement> elements=driver.findElements(By.tagName("H4"));
      //  System.out.println(elements.size());
        sleep(1000);
       driver.quit();

    }


}
