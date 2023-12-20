package day021_mrtt.assertions;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Hardassertion2 {
    @Test
    public void test1() {
        Assert.assertEquals(1, 1);
        System.out.println("Test1");

    }

    @Test
    public void test2() {
        Assert.assertTrue(false);
        System.out.println("Test2");


    }

    @Test(dependsOnMethods = "test2")
    public void test3() {
        Assert.assertNull(null);
        System.out.println("Test3");
    }

    @Test
    public void test4() {
        Assert.fail();
        System.out.println("Test4");
    }
}
