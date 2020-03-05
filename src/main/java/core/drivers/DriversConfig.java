package core.drivers;

import core.enums.SizeEnum;
import org.openqa.selenium.WebDriver;

/**
 * This interface is implemented by all drivers.
 */
public interface DriversConfig {

    /**
     * This method is used to set the headless value .
     * @param bool can be set to true or false so the headless option will be applied or not.
     * @return the headless value.
     */
    DriversConfig isHeadless(boolean bool);

    /**
     * This method is used to set the size of the browser.
     * @param size is an enum that has the required size inside itself;
     * @return the specified size
     */
    DriversConfig withSize(SizeEnum size);

    /**
     * This method will build the driver with all the configuration
     * @return
     */
    WebDriver build();
}
