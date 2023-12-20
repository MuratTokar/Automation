package day023_mrtt.xml1;

import org.testng.annotations.*;

public class Test1 {
    /*
     * BeforeTest(String testname)*/
    @BeforeSuite
    public void beforesuite() {
        System.out.println("BeforeSuite");

    }

    @BeforeTest
    public void start() {
        System.out.println("BeforeTest");

    }

    @AfterTest
    public void aftertset() {
        System.out.println("Aftertest");

    }

    @AfterSuite
    public void aftersuite() {
        System.out.println("aftersuite");

    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");

    }

    @Test
    public void test3() {
        System.out.println("test3");
    }

}
