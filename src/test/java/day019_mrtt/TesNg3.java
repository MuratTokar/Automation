package day019_mrtt;

import org.testng.annotations.*;

public class TesNg3 extends TesNG_Base {


    @Test
    public void test1(){    // once BeforMthod calisti, sonra test metodu calisti, sonra AfterMethod calisti
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
/*
Befor suit
Befor Test
Befor Class
Before Methot
Test 1
After Method
Before Methot
Test 2
After Method
After Class
After Test
After Suite

*/

}
