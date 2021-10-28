package utils.readers;


import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    private static Properties data = new Properties();
    public static String dataFilePath = "data";
    public static String apiParamValue = "apiParamValue";

    public static String getProperty(String fileName, String key){
        try {
            data.load(PropertyReader.class.getClassLoader().getResourceAsStream(fileName + ".properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getProperty(key);
    }
}
