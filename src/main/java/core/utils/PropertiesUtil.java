package core.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * This class is used to convert the properties from a file to a Properties java object;
 */
public class PropertiesUtil {

    /**
     * This method is used to get the properties from a properties file and store them inside an object;
     *
     * @param path of the properties file
     * @return the properties object
     */

    private static final Logger logger = LogManager.getLogger(PropertiesUtil.class);

    public static Properties getProperty(String path) {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            properties.load(fileInputStream);
        } catch (IOException e) {
            logger.error(e.getStackTrace());
            logger.error(e.getMessage());
        }
        return properties;
    }
}
