package day032_mrtt.map;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day032_mrtt/map"},
        glue = {"day032_mrtt/map"}
)

public class MapRunner extends AbstractTestNGCucumberTests {
}
