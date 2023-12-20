package day026_mrtt;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
// teslerle ilgili bsaladi ,bitti ,gecmedi gibi durumalri listener ile yakalariz
// sag tiklayip generit --implemets metot-sonra hangilerini istiyorsak seceriz

class MyListener implements ITestListener{
    @Override
    public void onTestSuccess(ITestResult result) { // test succes mi (basarili mi ) oldu burdan yakalariz
        ITestListener.super.onTestSuccess(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {// test fail mi oldu.Burada ekran goruntusu alinca test fail oldugunda alir
        ITestListener.super.onTestFailure(result);
    }
}
@Listeners(MyListener.class)
public class TestNgReport {
    @Test
    public void test1(){

    }
    @BeforeMethod
    public void beforeTest(){
        System.out.println("test basladi");
    }
}
