package day033_mrtt.test2_hooks.stepdefs;

import io.cucumber.java.*;

public class Hooks2 {



    @Before
    public void before1(Scenario scenario){
        System.out.println(scenario.getName());
    }

    @BeforeStep
    public void beforeStep(Scenario scenario){
        System.out.println("before step");
    }

    @AfterStep
    public void afterstep(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
    }

    @After
    public void after1(Scenario scenario){ // senaryo datalarini burda yakalarim
        System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        System.out.println("scenario.getName() = " + scenario.getName());
        System.out.println("scenario.getLine() = " + scenario.getLine());
        System.out.println("scenario.isFailed() = " + scenario.isFailed());
    }

}
