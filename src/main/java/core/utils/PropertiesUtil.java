package core.utils;

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
        public static Properties getProperty(String path) {
            Properties properties = new Properties();
            try {
                FileInputStream fileInputStream = new FileInputStream(path);
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return properties;
        }
}
