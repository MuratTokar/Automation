package day019_mrtt;

import org.testng.annotations.*;

public class TesNG_Base {
    @BeforeSuite
    public void beforSuite() {
        System.out.println("Befor suit");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforTest() {
        System.out.println("Befor Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforClass() {
        System.out.println("Befor Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethot() {  //run edilmiyor ama otomatik once calisacaktir
        System.out.println("Before Methot");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }
}