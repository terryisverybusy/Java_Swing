package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Utils {
    public static Path CONFIG_PATH = Paths.get("properties", "config.properties");
    public static Properties CONFIG_PROPS = getProperties(CONFIG_PATH);
    public static String delim = "||";

    public static Properties getProperties(Path p) {
        Properties props = new Properties();
        try {
            props.loadFromXML(Files.newInputStream(p));
        } catch (IOException e) {
            System.out.println("Fail to load properties");
        }
        return props;
    }
}