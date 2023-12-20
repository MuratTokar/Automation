package day028_mrtt_yml_Json;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Driver;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class ReadFiles extends BaseTest {
    @Test
    public void propertyFile1(){
      //  System.getProperties().forEach((k,v)-> System.out.println(k+":"+v));// sistem bilgisini verdi
        Properties properties=new Properties();
        properties.setProperty("url","https://google.com"); //kendimiz deger verdik
        properties.setProperty("a","b");

        System.out.println("properties.getProperty(\"url\") = " + properties.getProperty("url"));
        System.out.println("properties.getProperty(\"a\") = " + properties.getProperty("a"));
        properties.forEach((k,v)-> System.out.println(k+":"+v));
    }
    @Test
    public void testReadPropertyFromFile() throws IOException {
        Properties pro=new Properties();

        //burda okuyucu tanimladik ve file dosya yolunu verdik
        FileReader file=new FileReader("src/test/java/day028_mrtt/myProp1.properties");// mevcut dosyayi aldik
        pro.load(file);// okunan file yüklendi
        String url= pro.getProperty("oranhrm.url");
       // System.out.println(url);

        pro.forEach((k,v)-> System.out.println(k+":"+v));

        driver= Driver.getDriver();
        driver.get(pro.getProperty("oranhrm.url"));
        sleep(3000);
        driver.get(pro.getProperty("demoblaze.url"));
        sleep(3000);
    }
    @Test
    public void testReadWriteropertyFile() throws IOException {
        Properties pro=new Properties();
        String filePath="src/test/java/day028_mrtt/myProp1.properties";
        FileReader file=new FileReader(filePath);
        pro.load(file);// okunan file yüklendi
        System.out.println("Property File content");

        pro.forEach((k,v)-> System.out.println(k+":"+v));
        pro.setProperty("orangehrm.username","Admin");
        pro.remove("newKey");

        //yazici tanimliyoruz
        FileWriter writer=new FileWriter(filePath);// ustte dosya ustune yazacak
        pro.store(writer,"");

    }

}
