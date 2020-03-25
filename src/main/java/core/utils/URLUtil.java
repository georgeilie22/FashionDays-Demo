package core.utils;

import java.util.Properties;

public class URLUtil {
    private static String FASHIONDAYS_URL="src/main/resources/fashiondays.base_url.properties";

    public static String getURL(){
        Properties properties= PropertiesUtil.getProperty(FASHIONDAYS_URL);
        return properties.getProperty("base_url");
    }
}
