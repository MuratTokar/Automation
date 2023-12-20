package day026_mrtt;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReport1 {
    @Test
    public void test1(){
        // bu satir  web sayfasi olusturmak icin kullanilir
        ExtentSparkReporter html; // rapor icin html lazim

        //Extent report
        ExtentReports report; // icine yazilacak rapor

        // test olusturuluyor
        ExtentTest test; // test bilgileri

        // html olustururlur
        html=new ExtentSparkReporter("test-output/report.html");// html olustururp isim verdik.nereye kaydeilsin istersek yapariz

        // nesne olusturduk
        report=new ExtentReports();

        //extentReport u html ye ekledik
        report.attachReporter(html);

        // testi de burda create ettik.test edilen herseyi boylece rapora ekleyecek
        test=report.createTest("Test1","My First Test Report");

        // test icindeki gelismelere gore istenilen  log kaydi tutulur
        test.info("my first info comment");//test yazip noktaya tiklayinca eklemek istedigimiz herseyi ekleriz.ScreenSorts gibi

        test.log(Status.WARNING,"my log as Warning");
        test.warning("My log as warning ,without status");// ustteki ile ayni seyim ifade eder
        test.pass("Test is passed");

        test.addScreenCaptureFromPath("../Screenshots/MyWatchOage_20230831180251.png");// resim aldik ekledik

        //raporun sonuna eklemek istediklerimiz
        report.setSystemInfo("Team","QA Team");
        report.setSystemInfo("OS",System.getProperty("OS"));
        report.setSystemInfo("Directory",System.getProperty("user.dir"));
        report.setSystemInfo("Date Time", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss")));


        // sonunda report yazilir ve kapatilir.Yani flush edilir
        report.flush();


    }
    //systemproperty de neler oldugunu almak icin su sekilde metot yapabiliriz
    public static void main(String[] args) {
        System.getProperties().forEach(
                (k,v)->{
                    System.out.println(k + ":" + v);
                }
        );
    }
}
