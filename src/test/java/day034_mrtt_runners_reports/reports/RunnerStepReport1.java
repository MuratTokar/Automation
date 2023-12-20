package day034_mrtt_runners_reports.reports;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day034_mrtt_runners_reports/features"},
        glue = {"day034_mrtt_runners_reports/stepdefs"},
        plugin = {"pretty",
                "html:target/cucumber/cucumber.xml",
                "json:target/cucumber/cucumber.json",
                "testng:target/cucumber/cucumber.xml",
                " com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class RunnerStepReport1 extends AbstractTestNGCucumberTests {


}