package day031_mrtt.orangeHrm.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day031_mrtt/orangeHrm/feature"},
        glue = {"day031_mrtt/orangeHrm/stepdfs"}
)

public class OrangeRunner extends AbstractTestNGCucumberTests {
}
