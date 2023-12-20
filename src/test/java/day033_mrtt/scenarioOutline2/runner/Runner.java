package day033_mrtt.scenarioOutline2.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Driver1;

@CucumberOptions(
        features = {"src/test/java/day033_mrtt/scenarioOutline2/feature"},
        glue = {"day033_mrtt/scenarioOutline2/stepdefs"},
        plugin = {"pretty","json:target/cucumber/cucumber.json",
        "html:target/cucumber/cucumber.html"}
)

public class Runner extends AbstractTestNGCucumberTests {
    public static ThreadLocal<String> browsers=new ThreadLocal<>();// her thread icin ayri  yani farkli bir browser tanimlar

    @BeforeTest
    @Parameters("browser")
    public void beforetest(@Optional("chrome") String browser){
        Driver1.getDriver(browser);
       browsers.set(browser);

    }
    //runner ile
   // 1-TestNG
    // 2-cucumber
}
