package day031_mrtt.datatables;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day031_mrtt/datatables/Datatables.feature"},
        glue = {"day031_mrtt/datatables"}
)

public class DatatableRunner extends AbstractTestNGCucumberTests {
}
