package day033_mrtt.scenarioOutline2.stepdefs;

import day033_mrtt.scenarioOutline2.pageobjeckt.SdPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.Map;

public class SdStepdefs {
    SdPage page=new SdPage();
    @Given("sd user navigate to homepage")
    public void sdUserNavigateToHomepage() {
        page.gotopage();

    }
    @Given("sd user navigate with the following credentials")
    public void sdUserNavigateWithTheFollowingCredentials(DataTable table) {
        Map<String ,String> sdmap=table.asMap();
        String username=sdmap.get("username");
        String password=sdmap.get("password");
        page.sendkeys(page.lusername,username);
        page.sendkeys(page.lpassword,password);
        page.click(page.llogin);
    }

    @Then("login should be{string}")
    public void loginShouldBe(String result) {
        if (result.equalsIgnoreCase("true")){
            page.waitForVisibility(page.lshopcart);
        }else {
            page.waitForVisibility(page.lerror);
        }

    }


}
