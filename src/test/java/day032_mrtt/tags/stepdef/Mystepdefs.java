package day032_mrtt.tags.stepdef;

import io.cucumber.java.en.Given;

public class Mystepdefs {
    @Given("tags  Scenario {int} step {int}")
    public void tagsScenarioStep(int Scenario, int step) {
        System.out.println("Scenario" + Scenario + ", step " + step);
    }
}
