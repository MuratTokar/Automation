package day006_mrtt;

import day005_mrtt.BaseClas;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Tests01 extends BaseClas {
    String url = "http://opencart.abstracta.us";
    @Test
    public void test1() {
        //http://opencart.abstracta.us/ adresteki toplam  a elementlerinin sayisi kactir.Textlerini konsola yazdirin

        driver.get(url);
        //driver.findElements(By.cssSelector("a")); uzun yolu bu
        By aElementsCss = By.cssSelector("a");
        By aElementsXpath = By.xpath("//a");
        //WebElement element=driver.findElement(aElementsCss);// element oldugu icin ilk elemnti verecek ama bulamazsa hata verecek

        List<WebElement> elements = driver.findElements(aElementsCss);//elemnts ise hata vermez ve bulamazsa null verir
        driver.findElements(By.cssSelector("a"));
        System.out.println("syafdaki a elemnet sayisi= " + elements.size());

        for (WebElement element : elements) {
            if (element.getText().length() > 0) // text i olmayanari yazdirmak icin
                System.out.println(element.getText());
        }
        driver.quit();
    }

    @Test
    public void test2() {
        //1- "http://opencart.abstracta.us/" sayfasina git
        //2-searchbox a "Macbook" yazip serach butonuna tiklayin
        // serac butonunu sccselector ile bulmak iicn "mame " sini bulduk-name=serach
        // input[name='search'] yaziyoruz ama iki tane ccikiyor bu kez,- #search input- id si search olan inputu arariz
        //3-Macbook urununun sayfaya geldigini assert edin


        driver.get("http://opencart.abstracta.us/");//1 sietye gidildi
        By seratchInput=By.cssSelector("#search input");
        By seratchButton=By.cssSelector("#search button");
       // driver.findElement(seratchInput).sendKeys("MackBook"); bunu yerine önceki metodu kullanirim
        sendkeys(seratchInput,"MacBook");

        //driver.findElement(seratchButton).click();  bunu yerine önceki metodu kullanirim
        click(seratchButton);

        By macBook=By.xpath("//h4//a[text()='MacBook']");
        driver.findElement(macBook);


        driver.quit();
    }


        @Test
        public void test3() {

            driver.get(url);

            By aElementsXpath = By.xpath("//a");

            List<WebElement> elements = driver.findElements(aElementsXpath);
            List<WebElement> newList=elements
                    .stream()
                    .filter(e-> e.getText()
                            .length()>0)
                    .collect(Collectors.toList());
            // newList i stream in icine at ,filitrele  gelen elentinin e sinin  getText in  lenght i sifirdan buyukse bunu tekrar list te toplasin

            System.out.println("syafdaki a elemnet sayisi= " + newList.size());

            for (WebElement element : newList) {
                if (element.getText().length() > 0) // text i olmayanari yazdirmak icin
                    System.out.println(element.getText());
            }
            driver.quit();
        }

    }