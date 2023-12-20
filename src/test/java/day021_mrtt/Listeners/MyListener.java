package day021_mrtt.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener { // hatalari ITestListener ile yakayip yaziyoruz


    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Succes");// test basarili olunca bu otomatik calisir
        System.out.println(result.getName());
        System.out.println(result.getStartMillis());
        System.out.println(result.getEndMillis());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Fail");// basarisiz olunca bu calisir

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
