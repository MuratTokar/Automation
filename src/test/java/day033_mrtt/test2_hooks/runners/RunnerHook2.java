package day033_mrtt.test2_hooks.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day033_mrtt/test2_hooks/features"},
        glue = {"day033_mrtt/test2_hooks/stepdefs"},
       tags ="@smoke"
       // plugin ={"pretty"}// passt yada fail olanlarin durumuna bakariz

)

public class RunnerHook2 extends AbstractTestNGCucumberTests {
}
