package day029_mrtt;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utils.Driver;

import static day029_mrtt.Myelements.$;

public class MyElenetsTest {
    String url="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
    By lusername=By.cssSelector("input[name='username']");
    By lPassword=By.cssSelector("input[name='password']");
    By lLoginButton=By.xpath("//button[contains(.,'Login')]");
    @Test
    public void test1(){
        Driver.getDriver().get(url);
        $(lusername)
                .shouldBe(Conditions.visible)
                .sendKey("admin");
        $(lPassword)
                .sendKey("admin123");
        $(lLoginButton)
                .shouldBe(Conditions.clickable)
                .hover()
                .click();

    }
}
