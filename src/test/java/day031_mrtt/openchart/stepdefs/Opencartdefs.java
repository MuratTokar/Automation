package day031_mrtt.openchart.stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Driver;

import java.time.Duration;

public class Opencartdefs {

    WebDriver driver;
    WebDriverWait wait;
    By serachbox=By.cssSelector("input[name='search']");
    By serachproduks=By.cssSelector("div[class='product-thumb']");
    By searchHeaderText=By.xpath("//h2[text()='Search']");
    {
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    }



    @Given("user navigate to {string}")
    public void userNavigateTo(String url) {
        driver.get(url);

    }

    @When("user search for{string}")
    public void userSearchFor(String searchtext) {
        WebElement searchBox=wait.until(ExpectedConditions.visibilityOfElementLocated(serachbox));
        searchBox.clear();
        searchBox.sendKeys(searchtext, Keys.ENTER);
    }

    @Then("listed product number be {int}")
    public void listedProductNumberBe(int count) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchHeaderText));
        int listedProduks=driver.findElements(serachproduks).size();
        Assert.assertEquals(listedProduks,count);


    }
}
