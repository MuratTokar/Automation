package day032_mrtt.datrunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day032_mrtt/feature"},
        glue = {"day032_mrtt"}
)

public class runner6 extends AbstractTestNGCucumberTests {
}
