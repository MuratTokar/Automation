package day023_mrtt.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Test1 extends BaseTest{
By lUserName=By.xpath("//input[@name='username']");
By lPassword=By.xpath("//input[@name='password']");
By lButton=By.xpath("//button[@type='submit']");
By luser=By.xpath("//img[@class='oxd-userdropdown-img']");
    @Test
    public void test1(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUserName));
    }
    @Test(dependsOnMethods = "test1")
    public void fillLoginForm(){
        driver.findElement(lUserName).sendKeys("Admin");
        driver.findElement(lPassword).sendKeys("admin123");
        driver.findElement(lButton).click();
    }
    @Test(dependsOnMethods = "fillLoginForm")
    public void assertLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(luser));
    }

}
