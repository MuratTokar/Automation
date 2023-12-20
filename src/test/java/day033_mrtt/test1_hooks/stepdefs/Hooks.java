package day033_mrtt.test1_hooks.stepdefs;

import io.cucumber.java.*;

public class Hooks {

    // cucumberda ilk calisacak olan metot @BeforeAll dir
    // metot static olmalidir
    @BeforeAll
    public static void beforeAll(){
        System.out.println("beforeAll");

    }


    // her senaryo oncesi calisir
    @Before(order = 1)
    public void before1(){
        System.out.println("before1");
    }

  //  @Before(order = 2)
    @Before("@reg")
    public void before2(){
        System.out.println("before2");
    }

    @BeforeStep// her stepten once
    public void beforeStep(){
        System.out.println("before step");
    }


    @AfterStep
    public void afterstep(){
        System.out.println("afterstep");
    }

    // her senaryo sonrasi calisir
    @After(order = 1)
    public void after1(){
        System.out.println("after1");
    }


   // @After(order = 2)
    @After("@reg")// hangi anotation da calismasini istersek yazariz
    public void after2(){
        System.out.println("after2");
    }
    // cucumber da son caliscak olan metot
    // static olmak zorunda


    @AfterAll
    public static void afterAll(){
        System.out.println("afterAll");

    }
}
