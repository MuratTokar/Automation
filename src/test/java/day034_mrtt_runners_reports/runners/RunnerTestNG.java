package day034_mrtt_runners_reports.runners;

import org.testng.TestNG;

public class RunnerTestNG {
    public static void main(String[] args) {
        //cucumbur e burda main de testng ile run ettik
        //TestNg nesnesi olusturuluyor
        TestNG testNG=new TestNG();

        //run edilecek class lar array olarak belirtiliyor
        testNG.setTestClasses(new Class[]{Runner1CucumberOptions.class});

        // TestNG baslatiliyor
        testNG.run();
    }
}
