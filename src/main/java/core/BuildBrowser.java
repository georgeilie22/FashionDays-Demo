package core;

import core.drivers.ChromeConfig;
import core.drivers.DriversConfig;
import core.drivers.MozillaConfig;
import core.enums.BrowserEnum;
import core.enums.SizeEnum;
import org.openqa.selenium.WebDriver;

public class BuildBrowser  implements BrowserBuilder{

    public static final String WEBSITE = "https://www.fashiondays.ro/";
    private BrowserEnum browser;
    private DriversConfig driver;

    public BuildBrowser(BrowserEnum browser) {
        this.browser = browser;
    }

    /**
     * This method is instantiating a driver builder class
     * based on what driver is set in the constructor parameter;
     */
    private void startBrowser() {
        switch (browser) {
            case CHROME:
                driver = new ChromeConfig();
                break;
            case MOZILLA:
                driver = new MozillaConfig();
        }
    }


    @Override
    public BrowserBuilder isHeadless(boolean bool) {
        if (driver == null) startBrowser();
        driver.isHeadless(bool);
        return this;
    }


    @Override
    public BrowserBuilder withSize(SizeEnum size) {
        if (driver == null) startBrowser();
        driver.withSize(size);
        return this;
    }

    @Override
    public WebDriver build() {
        if (driver == null) startBrowser();
        return driver.build();
    }


}
