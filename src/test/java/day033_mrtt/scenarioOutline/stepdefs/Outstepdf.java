package day033_mrtt.scenarioOutline.stepdefs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.Map;

public class Outstepdf {
    @Given("so scenario {int} step {int}")
    public void soScenarioStep(int scenario, int step) {
    }

    @When("so login with the following data")
    public void soLoginWithTheFollowingData(DataTable table) {
        Map<String,String> map=table.asMap();
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));

    }

    @Given("so my name is {string}")
    public void soMyNameIs(String name) {
        System.out.println("My name : " + name);
    }

    @Given("so my age is {int}")
    public void soMyAgeIs(int age) {
        System.out.println("My age : " +age);
    }

    @Given("so my country  is {string}")
    public void soMyCountryIs(String country) {
        System.out.println("My country : " + country);
    }


}
