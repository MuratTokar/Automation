package day033_mrtt.test1_hooks.stepdefs;

import io.cucumber.java.en.Given;

public class HooksDef {
    @Given("hooks scenario {int} step {int}")
    public void hooksScenarioStep(int scenario, int step) {
        System.out.println("Scenario" + scenario + ", Step" + step);
       // Assert.assertTrue(step<3);// yani 3.step run edilmesin

    }
}
