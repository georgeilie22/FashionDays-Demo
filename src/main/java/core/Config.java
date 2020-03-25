package core;

import core.enums.BrowserEnum;
import core.enums.SizeEnum;
import core.utils.PropertiesUtil;

import java.util.Properties;

/**
 * This class is used to configure the browser specific properties
 */
public class Config {

    /**
     * @return the property as a boolean
     */
    public static boolean getHeadless() {
        return DTO.getBoolean();
    }

    /**
     * @return the SizeEnum value based on what is set in the config.properties file;
     */
    public static SizeEnum getSize() {
        return  SizeEnum.returnSize();
    }

    /**
     * @return the BrowserEnum value based on what is sit in the config.properties file;
     */
    public static BrowserEnum getBrowserType() {
       return BrowserEnum.returnBrowser();
    }

}
