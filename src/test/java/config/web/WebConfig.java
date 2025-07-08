package config.web;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:config/web/web.properties")
public interface WebConfig extends Config {

    @Key("browser")
    String browser();

    @Key("browserVersion")
    String browserVersion();

    @Key("timeout")
    long timeout();

    @Key("browserSize")
    String browserSize();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("remoteUrl")
    String remoteUrl();

    static WebConfig getInstance() {
        return ConfigFactory.create(WebConfig.class);
    }
}