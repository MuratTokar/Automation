package day030_mrtt.Definition2;

import io.cucumber.java.tr.Diyelimki;
import io.cucumber.java.tr.Eğerki;
import io.cucumber.java.tr.Ozaman;
import org.testng.Assert;

public class MyStepdefs {
    String str;
    String chr;
    @Diyelimki("metin{string} dir")
    public void metinDir(String text) {
        System.out.println(text +"kaydedildi");
        str=text;
    }

    @Eğerki("metnin {int}.karakterini alirsam")
    public void metninKarakteriniAlirsam(int n) {
        System.out.println(str + "´nin" + n + ". karakteri alindi");
        chr=str.charAt(n-1)+"";// index sifirdan basladigi icin -1 yapildi

    }

    @Ozaman("sonuc{string} olur")
    public void sonucOlur(String karakter){
        System.out.println("Assert islemi yapildi");
        Assert.assertEquals(chr,karakter);

    }
}
