package day032_mrtt.tags.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/day032_mrtt/tagsHooks/feature"},
        glue = {"day032_mrtt/tags/stepdef"},
        //tags ="@smoke"
        //tags ="@temp or @smoke" //anotation olanlari calistir
        //tags = "@smoke and @temp"
       // tags = "@smoke and not @temp"
       // tags = "@genel"
        //tags = "@özel"
        tags = "@genel and not @smoke"
)

public class runner8 extends AbstractTestNGCucumberTests {
}
