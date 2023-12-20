package day026_mrtt;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ExtentReport2 {
    ExtentSparkReporter html;
    ExtentReports report;
    ExtentTest test1,test2,test3;

    @BeforeSuite
    public void start(){
        html=new ExtentSparkReporter("test-output/report.html");
        report=new ExtentReports();
        report.attachReporter(html);
    }
    @AfterSuite
    public void end(){
        report.setSystemInfo("Team","QA Team");
        report.setSystemInfo("OS",System.getProperty("OS"));
        report.setSystemInfo("Directory",System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));
        report.flush();

    }

    @Test
    public void test1(){

        test1=report.createTest("Test1","My First Test Report");
        test1.log(Status.INFO,"Test basladi");
        try {
            test1.warning("Amannn asserte dikkat");
            Assert.assertEquals(1,new Random().nextInt(3));
            test1.pass("Test1 basarili");
        }catch (Exception|AssertionError e){
            test1.fail("test fail/n" + e.getMessage());
        Assert.fail();
        }
        test1.info("Test Bitti");

    }
    @Test
    public void test2(){

        test2=report.createTest("Test2","My First Test Report");
        test2.log(Status.INFO,"Test basladi");
        try {
            test2.warning("Amannn asserte dikkat");
            Assert.assertEquals(1,new Random().nextInt(3));
            test2.pass("Test2 basarili");
        }catch (Exception|AssertionError e){
            test2.fail("test fail/n" + e.getMessage());
           Assert.fail();
        }
        test2.info("Test Bitti");

    }
    @Test
    public void test3(){

        test3=report.createTest("Test3","My First Test Report");
        test3.log(Status.INFO,"Test basladi");
        try {
            test1.warning("Amannn asserte dikkat");
            Assert.assertEquals(1,new Random().nextInt(3));
            test1.pass("Test3 basarili");
        }catch (Exception|AssertionError e){
            test1.fail("test fail/n" + e.getMessage());
          Assert.fail();
        }
        test1.info("Test Bitti");

    }
}
