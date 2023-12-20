package day031_mrtt.gherkin;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features ={"src/test/java/day031_mrtt/gherkin"} ,
        glue = {"day031_mrtt/gherkin"}

)

public class RunnerGherkin extends AbstractTestNGCucumberTests {
}
