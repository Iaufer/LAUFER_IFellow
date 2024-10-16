package tools;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("file:src/test/resources/properties/config.properties")
public interface ConfigReader extends Config {

    @Key("task")
    String task();

    @Key("url")
    String url();

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("nameTask")
    String nameTask();

    static ConfigReader getInstance() {
        return ConfigFactory.create(ConfigReader.class);
    }
}