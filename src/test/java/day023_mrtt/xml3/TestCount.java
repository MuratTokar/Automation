package day023_mrtt.xml3;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCount {
    /*
    * BeforeTest(String testNmae):
    * test
    * Test1(int num): 0 num a kadar for ile saysin
    * Test2(int num):0 dan num a kadar toplasin
    * num xml dosyasina gelsin
    * xml icinde 3 test
    * test Test1
    * test Test2
    * test Test1 ve Test2
    * paralel calisacak
    * */
    @BeforeTest
    @Parameters({"testName"})
        public void start(String testName){
        System.out.println(Thread.currentThread().getName() +":"+testName);

    }
    @Test
    @Parameters("count")
    public void count(int num){
        for (int i = 0; i <=10 ; i++) {
            System.out.println(Thread.currentThread().getName() +":"+i);

        }

    }
    @Test
    @Parameters("sum")
    public void sum(int num){
        int sum=0;
        for (int i = 0; i <=num ; i++) {
            sum+=i;

        }
        System.out.println(Thread.currentThread().getName() +":"+sum);
    }


}
