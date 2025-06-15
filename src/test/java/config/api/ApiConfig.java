package config.api;

import org.aeonbits.owner.Config;


@Config.Sources("classpath:config/api/api.properties")
public interface ApiConfig extends Config {
    @Key("token")
    String token();

    @Key("baseUrl")
    String baseUrl();

    @Key("projectNumber")
    String projectNumber();
}