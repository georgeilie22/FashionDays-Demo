package core;

import core.utils.PropertiesUtil;

import java.util.Properties;

public class DTO {

    private static final String PATH = "src/main/resources/configs.properties";
    private static Properties properties = PropertiesUtil.getProperty(PATH);
    private static final String sizeProperty = properties.getProperty("size");
    private static final String browserProperty = properties.getProperty("browser");
    private static final Boolean booleanProperty= Boolean.parseBoolean(properties.getProperty("headless"));

    public static Boolean getBoolean() {
        return booleanProperty;
    }

    public static String getSize() {
        return sizeProperty;
    }

    public static String getBrowser() {
        return browserProperty;
    }


}
