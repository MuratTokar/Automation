package day030_mrtt.cucumber_01Definition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
/*
^baslangic sayisi (\\d+)$
regExp gösterimi
^:metnin basladigini
$:metnin bittigini gösterir
 (\d+):regExp,
 d:sayi
 +:1 ve daha fazla

*/

public class MyStepdefs {
    int sum;
    @Given("^baslangic sayisi (\\d+)$")
    public void baslangicSayisi(int num) {
        sum=num;
    }

    @When("bu sayiya {int} ekledigimde")
    public void buSayiyaEkledigimde(int n) {
        sum+=n;
    }

    @Then("sonuc {int} olmali")// ya bunu  yada sonuc ALI VELi olan kodu kullanirim
    public void sonucOlmali(int total) {
        Assert.assertEquals(sum,total);

    }

    @And("sonuc uygun")
    public void sonucUygun() {
        System.out.println("metin");
    }

    @And("netice {string} olmali")
    public void neticeOlmali(String text) {
        System.out.println(text);
    }
    @Given("^sonuc (ALI|VELI) olmali$")
    public void sonucOlmali(String text) {
        System.out.println(text);
    }


}
