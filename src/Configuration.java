import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private Properties properties;

    public Configuration() {
        this.properties = new Properties();
    }

    public void load() {
        try (InputStream input = Configuration.class.getClassLoader().getResourceAsStream("config.properties")) {

            // load a properties file
            this.properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String get(String property) throws ConfigurationException {
        try {
            return this.properties.getProperty(property);
        } catch (Exception e) {
            throw new ConfigurationException("Configuration " + property + " not found");
        }
    }

}
