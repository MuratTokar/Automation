package day030_mrtt.Definition2;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features={"src/test/java/day030_mrtt/Definition2/Definition02.feature"},
        glue ="day030_mrtt/Definition2"




)


public class Runner2 extends AbstractTestNGCucumberTests {
}
