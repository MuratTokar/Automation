package day033_mrtt.test1_hooks.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day033_mrtt/test1_hooks/features"},
        glue = {"day033_mrtt/test1_hooks/stepdefs"}
        // plugin steplerle ilgili rapor ve diger detaylari verir
       // plugin ={"pretty"}// passt yada fail olanlarin durumuna bakariz
)

public class RunnerHook extends AbstractTestNGCucumberTests {
}
