package day034_mrtt_runners_reports.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //feature yolu content rootdan itibaren verilir
        // feature dosyalari HDD nin herhangi bir yerinde olabilir,virgul ile adresini belirtiriz
        // features = {"src/test/java/day034_mrtt_runners_reports/features/Feature35.feature","d:/"},
        features = {"src/test/java/day034_mrtt_runners_reports/features/Feature35.feature"},

        // stepdefs yoludur ve Source root tan itibaren baslar
        glue = {"day034_mrtt_runners_reports/stepdefs"},

        // senaryo taglari
        tags = "@smoke",// smoke olanlari run edecek


        // consol output unun renkli yada monokrom olmasi
        monochrome = true,

        //// scenario ismine gore run eder,icine 1 yazarsak icinde 1 gecen senayryolari run eder
        name = {"Scenario1"},// burdadad sadece senaryo1 i run eder,virgul koyup baska senaryo da yazabilirz


        // yada {".*1.*"} icinde 1 gecenleri run et(. nokta 1 karakter) (*  sifir veya daha fazla bir veya daha fazla)
        // 1 in sagindada solundada metin olabilir
        // {".*1"} sadece 1 ile biten
        //".*smoke" :smoke ile biten
        //"smoke.*" :smoke ile baslayan


        dryRun = true,// sadece featurede tanimli steplerin stepdefs leri var mi
        // onu kontrol eder.stpeler duzenli tanimlanmis midir

        publish = true,//rapor varsa cucumbur un kendii sitesine gider
        plugin = {"pretty",
                // burda rapor olusturuyoruz
                "html:target/cucumber/cucumber.xml",

                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml"

        }


)

public class Runner1CucumberOptions extends AbstractTestNGCucumberTests {
}
