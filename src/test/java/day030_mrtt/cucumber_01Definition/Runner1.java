package day030_mrtt.cucumber_01Definition;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//cucumber in feature ,stepdefs,plugings gibi ozelliklerinin tanimlandigi yerdir
@CucumberOptions(
        //ctr+space tusuna basip fatures seciyoruz ve features file nin yolunu yaziyoruz
        features = {"src/test/java/day030_mrtt/cucumber_01Definition/MyFirstFeature.feature"},//java dosyasi degil src altina herhangi bir yere yazabiliriz
        //birden fazla features yazabiliriz.package yolunu versem altindaki tum features leri run eder
        //glue:stepdefinions larin oldugu package yolunu giriyoruz.javadan dan itibaren aliyoruz
        glue = {"day030_mrtt/cucumber_01Definition"}

)
public class Runner1 extends AbstractTestNGCucumberTests {//run etmek icin extends ediyoruz.ust tarafda @cucumberOptions() ekliyoruz
}
