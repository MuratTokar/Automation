package day020_mrtt.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

  public void click(WebElement element){
    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
  }

  public void sendKeys(WebElement element,String text){
    wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
  }
  public void sleep(long millis){
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}

