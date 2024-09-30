package tools;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("file:src/test/resources/conf.properties")
public interface Prop extends Config {

    @Key("FILE_PATH")
    String FILE_PATH();

    @Key("BASE_URL_CREATE_USER")
    String BASE_URL_CREATE_USER();

    @Key("BASE_URL")
    String BASE_URL();

    @Key("CHARACTER_NAME")
    String CHARACTER_NAME();

    static Prop getInstance() {
        return ConfigFactory.create(Prop.class);
    }
}
