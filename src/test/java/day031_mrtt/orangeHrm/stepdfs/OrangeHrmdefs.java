package day031_mrtt.orangeHrm.stepdfs;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;
import java.util.Map;

public class OrangeHrmdefs {
    String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    WebDriver driver;
    WebDriverWait wait;
    By lUsername=By.cssSelector("input[name='username']");
    By lPassword=By.cssSelector("input[name='password']");
    By loginbutton=By.cssSelector("button[type='submit']");
    By lAss=By.xpath("//p[@class='oxd-userdropdown-name']");
   public OrangeHrmdefs(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Given("user on homepage")
    public void userOnHomepage()  {
        driver.get(url);
    }

    @When("user login with the following credentials")
    public void userLoginWithTheFollowingCredentials(DataTable table) {
        Map<String,String> map=table.asMap();
        String username=map.get("username");
        String password=map.getOrDefault("password","admin123");// map tan aradigim pass yoksa admin123 u defaul olarak alsin
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys(username);
        driver.findElement(lPassword).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginbutton)).click();

    }

    @Then("login should be successful")
    public void loginShouldBeSuccessful() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lAss));
    }
}
