package day010_mrtt;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.time.Duration;

public class ImlicitlyWait extends BaseTest {
    /*
    * 1-implicitly wait
    * Driver bünyesindedir.Bu bekleme element precence oluncaya kadar her element icin beklenir
    * precence=var oluncaya kadar.Kodlarda olan element presence dir
    * 2-Explicit wait
    * 3-Fluent wait
    * */
    @Test
    public void test1(){
        driver= Driver.getDriver();
        // findElement ile aranan tum elementler icin max 10 sn bekler.surali kontrol eder 10 sn baoyunca
        // her yarim saniyede bir ko9ntrol eder
        // drivere bir kez tanimlanir .elemente ozel olan bir durumu beklemez.element var mi yok mu kod icinde ona bakar
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}
