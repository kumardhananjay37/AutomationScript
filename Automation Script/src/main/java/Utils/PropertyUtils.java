package Utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertyUtils {

    public PropertyUtils() {
        System.out.println(PropertyUtils.class);
    }

    public static String path = System.getProperty("user.dir") + "/src/main/resources/AutomationScriptConfig.properties";

    public static String propertyValueOf(String text) {
        FileReader reader;
        Properties p;
        String dataToBeReturned = null;
        try {
            reader = new FileReader(path);

            p = new Properties();
            p.load(reader);
            dataToBeReturned = p.getProperty(text);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("");
        }
        return dataToBeReturned;
    }
}
