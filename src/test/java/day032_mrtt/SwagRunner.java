package day032_mrtt;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day032_mrtt"},
        glue = {"day032_mrtt"}

)

public class SwagRunner extends AbstractTestNGCucumberTests {
}
