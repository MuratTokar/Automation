package day020_mrtt.pom.withBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
  protected   WebDriver driver;
  protected   WebDriverWait wait;


  protected BasePage(WebDriver driver){
    this.driver = driver;
    wait=new WebDriverWait(driver, Duration.ofSeconds(10));
  }

  public void click(By locator){
    wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
  }

  public void sendKeys(By locator,String text){
    wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(text);
  }
  public void sleep(long millis){
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

