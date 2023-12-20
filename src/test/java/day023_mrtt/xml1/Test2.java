package day023_mrtt.xml1;

import org.testng.annotations.*;

public class Test2 {
    /*
     * BeforeTest(String testname)*/
    @BeforeSuite
    public void beforesuite() {
        System.out.println("BeforeSuite-1");

    }

    @BeforeTest
    public void start() {
        System.out.println("BeforeTest-1");

    }

    @AfterTest
    public void aftertset() {
        System.out.println("Aftertest-1");

    }

    @AfterSuite
    public void aftersuite() {
        System.out.println("aftersuite-1");

    }

    @Test
    public void test1() {
        System.out.println("test1-1");
    }

    @Test
    public void test2() {
        System.out.println("test2-1");

    }

    @Test
    public void test3() {
        System.out.println("test3-1");
    }

}
