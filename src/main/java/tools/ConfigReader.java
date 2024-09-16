package tools;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    public static Properties confData() {
        Properties properties = new Properties();
        try(FileInputStream input = new FileInputStream("src/main/resources/config.properties")){
            properties.load(input);
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }
}
