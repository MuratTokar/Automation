package day006_mrtt;

import org.testng.annotations.Test;

public class _006TestNGTestAnnotation {
    @Test
    public void test1(){ // her seferinde main metodu yazmicam bu sayede
          //testNg testleri run edildiginde mevcut class tan bir nesne olusturur.ve istenen   @Test i run eder
         // sanki --->>   _006TestNGTestAnnotation testclass=new _006TestNGTestAnnotation();
        // testClass.test1();
        System.out.println("1");

        //Assert.assertEquals(actual,expected,"hata durumunda aciklama"); iki deger esit mi
        //Assert.assertTrue(boolean); boolean true olmali
        //Assert.assertFalse(boolean); boolean false olmali
    }
    @Test
    public void test2(){
        System.out.println("2");
    }
}
