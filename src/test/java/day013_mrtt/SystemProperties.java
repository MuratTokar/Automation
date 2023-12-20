package day013_mrtt;

public class SystemProperties {
    public static void main(String[] args) {
      //  System.getProperties().forEach((k,v) -> System.out.println(k+" : " + v));// bu bize sistemle ilgili tüm blgileri verir
        System.setProperty("win","winname");
        System.out.println(System.getProperty("win"));//winname----burda ikili calisir.Yani key gibi
        /*
        * "key" : "value"
        * "key" : "value"
        *
        * bu sekilde calisir
        * */

    }
}
