package day022_mrtt;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataProvider {
    @Test
    public void test1() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);

        }
    }

    //Test methoduna nasil data aktarilir.1 tanesi DataPovider dir
    @Test(dataProvider = "data2")
    void test2(int i) {//bu sekil eklesem data nerede sorar.Provider i asagidadir
        System.out.println(i);
    }

    // DataProvider in Objeckt [][] return etmeli
    @DataProvider
    public Object[][] data2() {
        return new Object[][]{
                {1},// her biri icin ustte testi ayri ayri yapacak
                {2},
                {3}
        };

    }

    @Test(dataProvider = "myData3")
    void test3(String name, int i) {//bu sekil eklesem data nerede sorar.Provider i asagidadir
        System.out.println(name + ":" + i);
    }

    @DataProvider(name = "myData3")
    public Object[][] data3() {
        return new Object[][]{
                {"Ali", 1},
                {"Weli", 2},
                {"Deniz", 5}

        };
    }
}