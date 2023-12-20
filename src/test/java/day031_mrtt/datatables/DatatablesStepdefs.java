package day031_mrtt.datatables;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DatatablesStepdefs {
    @Given("write the follaving numbers {int}, {int}, {int}, {int}, {int}")
    public void writeTheFollavingNumbers(int num0, int num1, int num2, int num3, int num4) {

        System.out.println("**************************************");
    }

    @Given("write the folloving  numbers")
    public void writeTheFollovingNumbers(DataTable table) {// icine Datatable yazdik.cunku int leri almadi
        List<Integer> list = table.asList(Integer.class);//string algiladi ve icine Integer.class yazdik.integere cevirecek
        list.forEach(n -> System.out.println(n));

        System.out.println("*************************************");
    }

    @Given("write the folloving  string")
    public void writeTheFollovingString(DataTable table) {
        List<String> list = table.asList(String.class);// icii bos biraktik cunku defaul degeri string.
        // double olsaydi icine double yazmaliydim
        list.forEach(System.out::println); // bu metot sistemi ile .istersek yukaridaki gibide yapabiliriz

        System.out.println("*************************************");
    }

    @Given("write the folloving  liatoflists")
    public void writeTheFollovingLiatoflists(DataTable table) {
        List<List<String>> lists = table.asLists();
        lists.forEach(list -> {
            list.forEach(s -> System.out.print(s + "\t"));
            System.out.println(); // enter attik

        });
        System.out.println("***********************************");
    }
    @Given("write the folloving  liatoflists as int")
    public void writeTheFollovingLiatoflistsAsInt(DataTable table) {
        List<List<Integer>> lists = table.asLists(Integer.class);
        AtomicInteger sum= new AtomicInteger();
        lists.forEach(list -> {
                    list.forEach(s -> { // normal for ile yapsak atomic e gerek yok
                        System.out.print(s + "\t");
                        sum.addAndGet(s);// sum un alti kirmizi idi.
                        // sag tiklayip atomic yapinca  ustte AtomicStirng objesi creat etti ve sum a .addAndGet ekledi
                });
            System.out.println(); // enter attik

        });
        System.out.println(sum);
        System.out.println("***************************************");
    }


    @Given("write the following as map")
    public void writeTheFollowingAsMap(DataTable table) {
        Map<String,String> map=table.asMap();
        System.out.println(map.get("username"));
        System.out.println(map.get("password"));
        System.out.println(map.get("firstname"));
        System.out.println(map.get("lastname"));

        map.forEach((k,v) ->System.out.println(k + ":" +v));
        System.out.println("*********************************");
    }

    @Given("write the following numbers as map")
    public void writeTheFollowingNumbersAsMap(DataTable table) {
        Map<Integer,Double> map=table.asMap(Integer.class,Double.class);
        map.forEach((k,v) -> System.out.println(k+":"+v));

    }

    @Given("write the following maps")
    public void writeTheFollowingMaps(DataTable table) {
        List<Map<String,String>> list=table.asMaps();
        list.forEach(m ->{
                   m.forEach((k,v) -> System.out.println(k+":"+v));
            System.out.println();
                   
               });
        
        
    }
}