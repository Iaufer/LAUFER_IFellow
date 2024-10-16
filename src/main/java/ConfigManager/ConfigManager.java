package ConfigManager;

import tools.ConfigReader;

public class ConfigManager {
    private final static ConfigReader config = ConfigReader.getInstance();


    public static String getTask() {
        return config.task();
    }

    public static String getUrl() {
        return config.url();
    }

    public static String getLogin() {
        return config.login();
    }

    public static String getPassword() {
        return config.password();
    }

    public static String getNameTask() {
        return config.nameTask();
    }

    public static String getChromeDriverPath(){return config.chromeDriverPath(); }
}
