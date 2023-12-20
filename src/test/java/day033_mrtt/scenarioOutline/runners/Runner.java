package day033_mrtt.scenarioOutline.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day033_mrtt/scenarioOutline/features/ScenarioOutline.feature"},
        glue = {"day033_mrtt/scenarioOutline/stepdefs"},
        tags = "@so2"
)

public class Runner extends AbstractTestNGCucumberTests {
}
