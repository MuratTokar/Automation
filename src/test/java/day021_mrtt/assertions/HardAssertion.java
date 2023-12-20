package day021_mrtt.assertions;
/*
* Assert yapildiginda hata olursa test orada kesilir
* Assert.assertTrue(false);
* */

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
    @Test
    public void testAssertionsEquals() {
        int a = 2;
        Assert.assertEquals(a, 2);//actuel=sistemden gelen,expected=bekledigim
        Assert.assertEquals(a, 2, a + "sayisi 2 ye esit degildir");//actuel=sistemden gelen,expected=bekledigim


    }

    @Test
    public void testAssertionTrue() {
        int num1 = 2;
        int num2 = 3;
        //conditions un true olmasini bekler
        // Assert.assertTrue(num1<num2);
        Assert.assertTrue(num1 < num2, num1 + " ," + num2 + "den kücük degil");// yada böyle
    }

    @Test
    public void testAssertionFalse() {
        int num1 = 3;
        int num2 = 2;
       Assert.assertFalse(num1<num2);
       //  Assert.assertFalse(num1 < num2, num1 + " ," + num2 + "den kücük degil");// yada böyle
    }
}