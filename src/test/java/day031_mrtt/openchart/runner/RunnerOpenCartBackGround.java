package day031_mrtt.openchart.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        //feature dosyalarinin yolu ,content roottan baslar.
        features = {"src/test/java/day031_mrtt/openchart/features/openchartBackground.feature"},
        //stepdefs yolu,source roottan baslar
        glue = {"day031_mrtt/openchart/stepdefs"}
        //true ise sadece featuredeki steplerin tanimlanip tanimlanmadigini  kontrol eder.stepleri run etmez.sadece steplerin varligini sorgular
       // dryRun = true

)

public class RunnerOpenCartBackGround extends AbstractTestNGCucumberTests {
}
