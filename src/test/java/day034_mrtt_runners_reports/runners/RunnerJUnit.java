package day034_mrtt_runners_reports.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
public class RunnerJUnit {
    public static void main(String[] args) {
        JUnitCore junit=new JUnitCore();
        junit.run(new Class[]{Runner3_JUnit.class});

    }
}
