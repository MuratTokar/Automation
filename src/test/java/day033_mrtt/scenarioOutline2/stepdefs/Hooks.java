package day033_mrtt.scenarioOutline2.stepdefs;

import day033_mrtt.scenarioOutline2.runner.Runner;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.Driver1;

public class Hooks {
    @Before
    public void before(){
        Driver1.getDriver(Runner.browsers.get());
    }
    @After
    public void after(){
        Driver1.quit();
    }
}
