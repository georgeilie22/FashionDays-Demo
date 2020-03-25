package core;

import core.drivers.DriversConfig;
import core.enums.SizeEnum;
import org.openqa.selenium.WebDriver;

public interface BrowserBuilder {

    /**
     * This method is used to set the headless value .
     * @param bool can be set to true or false so the headless option will be applied or not.
     * @return the headless value.
     */
    BrowserBuilder isHeadless(boolean bool);

    /**
     * This method is used to set the size of the browser.
     * @param size is an enum that has the required size inside itself;
     * @return the specified size
     */
    BrowserBuilder withSize(SizeEnum size);

    /**
     * This method will build the driver with all the configuration
     * @return
     */
    WebDriver build();
}
