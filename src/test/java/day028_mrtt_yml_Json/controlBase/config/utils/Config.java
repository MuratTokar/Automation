package day028_mrtt_yml_Json.controlBase.config.utils;

import lombok.Data;

@Data // bu sekilde getter ve setter metotlari aktif edildi
public class Config {
    private String url;
    private String username;
    private String password;
}
