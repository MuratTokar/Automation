package day041_mrtt_xcelolusturma.OrangHRM;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/day041_mrtt_xcelolusturma/OrangHRM/Login.feature",
        glue = "day041_mrtt_xcelolusturma/OrangHRM/Orangestepdefs.java"
)

public class Runner extends AbstractTestNGCucumberTests {
}
