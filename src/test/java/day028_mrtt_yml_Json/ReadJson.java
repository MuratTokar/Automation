package day028_mrtt_yml_Json;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class ReadJson {
    @Test
    public void ReadJson1() throws IOException {
        String jsonpath = "src/test/java/day028_mrtt/myJson.json";
        ObjectMapper mapper = new ObjectMapper();
        MyPojo myPojo = mapper.readValue(new FileReader(jsonpath), MyPojo.class);
        myPojo.getUrl();
    }
}
