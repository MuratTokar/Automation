package day034_mrtt_runners_reports.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day034_mrtt_runners_reports/features/Feature35.feature"},

        glue = {"day034_mrtt_runners_reports/stepdefs"},
        plugin = {"pretty",
        "html:target/cucumber/cucumber.xml",
        "json:target/cucumber/cucumber.json",
        "testng:target/cucumber/cucumber.xml"
        }
)
public class Runner1_systemProperty extends AbstractTestNGCucumberTests {

    {
       /*
        public Runner1_systemProperty() {
        System.setProperty("cucumber.publish.quite", "true");
        System.setProperty("cucumber.features", "src/main/java/gun35_runners_reports_turgut/features");
        System.setProperty("cucumber.glue", "gun35_runners_reports_turgut/stepdefs");
        System.setProperty("cucumber.filter.tags", "@regression");
        System.setProperty("cucumber.execution.dry-run", "true");
    }*/

        // system property ye asagidaki degisken set edilirse
       // diger cucumber options lari system property den okunur
       // System.setProperty("cucumber.publish.quite", "true");
      // System.setProperty("cucmber.features","C:\\GuideSoft\\e2etestautomation\\src\\test\\java\\day034_mrtt_runners_reports\\runners\\Runner1_systemProperty.java");
        // cucumber.features : absolute path alir


    }
}