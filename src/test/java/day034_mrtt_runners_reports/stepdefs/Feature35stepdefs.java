package day034_mrtt_runners_reports.stepdefs;

import io.cucumber.java.en.Given;
import org.testng.Assert;

public class Feature35stepdefs {
    @Given("rr Sceranio {int} Step {int}")
    public void rrSceranioStep(int scenario, int step) {
        System.out.println("sceranio" + scenario + "step" + step);
    }

    @Given("rr is {int} equals to {int}")
    public void rrIsEqualsTo(int num1, int num2) {
        Assert.assertEquals(num1,num2);
    }
}
