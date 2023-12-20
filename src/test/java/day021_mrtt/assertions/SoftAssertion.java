package day021_mrtt.assertions;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    SoftAssert softAssert;

    @BeforeTest
    public void beforTest() {
        softAssert = new SoftAssert();
    }

    @AfterTest
    public void afterTest() {
        softAssert.assertAll();// butun assertlae en sonunda yapilacak
    }

    @Test
    public void test1() {
        softAssert.assertEquals(1, 1);
        System.out.println("Test1");
    }

    @Test
    public void test2() {
        softAssert.assertTrue(false);
        System.out.println("Test2");
    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        softAssert.assertNull(null);
        System.out.println("Test3");
    }

    @Test
    public void test4() {
        softAssert.assertNotEquals(1, 2);
        System.out.println("Test4");
    }
}
