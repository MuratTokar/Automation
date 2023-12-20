package day032_mrtt;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class SwagDemo {
    WebDriver driver;
    WebDriverWait wait;
    By lusername=By.cssSelector("input[id='user-name']");
    By lpass=By.cssSelector("input[id='password']");
    By lloginbut=By.cssSelector("input[id='login-button']");
    By ass=By.xpath("//span[text()='Products']");
   public SwagDemo(){
        driver= Driver.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @When("user input username as {string}")
    public void userInputUsernameAs(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lusername)).sendKeys(username);


    }

    @And("user input password as {string}")
    public void userInputPasswordAs(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lpass)).sendKeys(password);

    }

    @And("user click to login button")
    public void userClickToLoginButton() {
        driver.findElement(lloginbut).click();
    }

    @Then("loginn should be successful")
    public void loginnShouldBeSuccessful() {
       wait.until(ExpectedConditions.presenceOfElementLocated(ass));
    }
}
