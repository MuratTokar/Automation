package day032_mrtt.map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class Mapdef {
    List<String> cities;
    List<List<String>> alllcities;
    int count;
    @Given("my string is a follows")
    public void myStringIsAFollows(DataTable table) {
       cities =table.asList();
    }

    @When("my data is as follows")
    public void myDataIsAsFollows(DataTable table) {
      alllcities =table.asLists();
    }


    @Then("the count of the cities are {int}")
    public void theCountOfTheCitiesAre(int num) {
        for (String city : cities) {
            for (List<String> alllcity : alllcities) {
                for (String s : alllcity) {
                    if (s.equalsIgnoreCase(city))
                     count++;

                }

                
            }
            
        }
        Assert.assertEquals(count,num);
    }
}
