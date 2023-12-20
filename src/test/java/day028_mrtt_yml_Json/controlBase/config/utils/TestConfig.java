package day028_mrtt_yml_Json.controlBase.config.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.FileReader;
import java.io.IOException;

public class TestConfig {
   private String configfile="src/test/java/day028_mrtt/controlBase/config/config.yml";
   private ObjectMapper mapper;
  private   FileReader file;
   private Config config;
   private TestConfig(){

   }

    public Config getConfig(){
       mapper=new ObjectMapper(new YAMLFactory());
        try {
          file =new FileReader(configfile);
          config=mapper.convertValue(file, Config.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
return config;
    }
}
