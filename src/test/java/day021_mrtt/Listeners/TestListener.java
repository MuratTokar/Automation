package day021_mrtt.Listeners;

import org.testng.annotations.*;
@Listeners(MyListener.class)// bu metot ile  MyListener ile baglanti kurariz

public class TestListener {

    @BeforeSuite
    public void beforSuite(){
        System.out.println("BeforSuite");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("BeforeTest");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("AfterTest");
    }
    @Test(testName = "my test 1")
    public void test1() {
        System.out.println("Test1");
    }
    @Test(successPercentage = 50,invocationCount = 20)//test 20 kez run edilecek.
    // ve %50 basarili olursa yeter
    public void test2() {
        System.out.println("Test2");
    }
    @Test
    public void test3(){
        System.out.println("Test3");
    }
    @Test
    public void test4() {
        System.out.println("Test4");
    }
}
