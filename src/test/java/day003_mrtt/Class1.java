package day003_mrtt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Class1 {
    @Test
    public void test1(){
        int  actual= ClassTest.sum(3,8);
        int expected=11;
        Assert.assertEquals(actual,expected,"test passt nicht");
       // System.out.println("test passt"); boylede mesaj yazilabilir

        // bu sekilde de olur
       // if (actual !=expected){
         //   throw new RuntimeException("esit degil");

        }

    }

