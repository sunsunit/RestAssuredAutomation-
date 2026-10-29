import java.io.InputStream;
import java.util.Properties;
 
public class Config {
 
    private static final Properties properties =
            new Properties();
 
    static {
        try (InputStream input =
                Config.class.getClassLoader()
                        .getResourceAsStream("config.properties")) {
 
            if (input == null) {
                throw new IllegalStateException(
                        "config.properties not found");
            }
 
            properties.load(input);
 
        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to load configuration", e);
        }
    }
 
    public static String getBaseUri() {
        return properties.getProperty("base.uri");
    }
}