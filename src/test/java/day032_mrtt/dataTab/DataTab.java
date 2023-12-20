package day032_mrtt.dataTab;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.util.List;

public class DataTab {
   //int num;
     int sum;
    @Given("initial value is {int}")
    public void initialValueIs(int num) {
        sum+=num;
       // this.num=num;
    }

    @When("user add the following numbers")
    public void userAddTheFollowingNumbers(DataTable table) {
        List<Integer> numbers=table.asList(Integer.class);
        numbers.forEach(n -> sum+=n);

    }

    @Then("sum schould be {int}")
    public void sumSchouldBe(int toplam) {
        Assert.assertEquals(sum,toplam);
    }
}
