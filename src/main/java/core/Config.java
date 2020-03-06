package core;

import core.enums.BrowserEnum;
import core.enums.SizeEnum;
import core.utils.PropertiesUtil;

import java.util.Properties;

/**
 * This class is used to configure the browser specific properties
 */
public class Config {

    private static final String PATH = "src\\main\\resources\\configs.properties";
    private static Properties properties = PropertiesUtil.getProperty(PATH);
    private static final String sizeProperty = properties.getProperty("size");
    private static final String browserProperty = properties.getProperty("browser");

    /**
     * @return the property as a boolean
     */
    public static boolean getHeadless() {
        return Boolean.parseBoolean(properties.getProperty("headless"));
    }

    /**
     * @return the SizeEnum value based on what is set in the config.properties file;
     */
    public static SizeEnum getSize() {
        if (sizeProperty.equalsIgnoreCase("max")) {
            return SizeEnum.MAX;
        } else if (sizeProperty.equalsIgnoreCase("phone")) {
            return SizeEnum.PHONE;
        } else return SizeEnum.TABLET;
    }

    /**
     * @return the BrowserEnum value based on what is sit in the config.properties file;
     */
    public static BrowserEnum getBrowserType() {
        if (browserProperty.equalsIgnoreCase("chrome")) {
            return BrowserEnum.CHROME;
        } else return BrowserEnum.MOZILLA;
    }

}
