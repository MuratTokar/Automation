package day026_mrtt;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNgReport2 {
    /*
    * Menu -> Run -> Edit Configuration
    * Sol taraftan ilgili test class i secilir
    * sag tarafata Listener tabi secilir
    * Alttaki + ya basilir
    * Acilan kutuda Reporter yazlir
    * Listelenen eklentilerden  eMailable reporter secilir
    * Apply -> ok
    *
    * sol tarafta project te allta test-output class ina sonuc gelir .tiklanip chrome yada baska bir tarayici ile acilir
    *
    * */
    @Test
    public void test1(){
        Assert.assertEquals(1,1);

    }
    @Test
    public void test2(){
        Assert.assertEquals(1,2);

    }
    @Test
    public void test3(){
        Assert.assertEquals(2,2);

    }
}
