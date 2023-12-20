package day032_mrtt;

import day030_mrtt.cucumber_01Definition.Runner1;
import io.cucumber.core.runner.Runner;
import org.testng.annotations.Test;

import java.util.*;

public class ListVsMap {
    int num=3;
    @Test
    public void listMap() {
        List<String> list = new ArrayList<>(Arrays.asList("Ali", "Deniz", "Ankara"));

        Map<String, String> map = new HashMap<String, String>() {{
            put("name", "Ali");
            put("lastname", "Deniz");
            put("city", "Ankara");

        }};
        System.out.println(list.get(0));// list icin
        System.out.println(map.get("name")); // map icin


    }

    @Test
    public void testObject() {
        int[] arrint = {1, 2, 3};
        double[] arrDouble = {1.2, 1.3};
        Class[] arrClass = {ListVsMap.class, Runner.class, Runner1.class};
        Object[] arr={1,"2",new ListVsMap()};
        System.out.println(((ListVsMap)arr[2]).num);
    }

    @Override
    public String toString() {
        return "ListVsMap{" +
                "num=" + num +
                '}';
    }
}