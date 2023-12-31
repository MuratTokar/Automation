package day034_mrtt_runners_reports.stepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.Driver;

public class Hooks {
    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()){
            scenario.log(scenario.getName() + "failled");
            TakesScreenshot screenshot= (TakesScreenshot) Driver.getDriver();
            byte[] resim=screenshot.getScreenshotAs(OutputType.BYTES);
            scenario.attach(resim,"image/png","Hata resmi");
        }
    }
}
