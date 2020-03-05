package core.drivers;

import core.enums.BrowserEnum;
import core.enums.SizeEnum;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class MozillaConfig implements DriversConfig {
    boolean headlessValue;
    SizeEnum browserSize;

    @Override
    public DriversConfig isHeadless(boolean bool) {
        headlessValue = bool;
        return this;

    }

    @Override
    public DriversConfig withSize(SizeEnum size) {
        browserSize = size;
        return this;
    }

    @Override
    public WebDriver build() {
        System.setProperty(BrowserEnum.MOZILLA.getKey(), BrowserEnum.MOZILLA.getPath());
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (headlessValue) firefoxOptions.setHeadless(true);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        if (browserSize == SizeEnum.MAX) driver.manage().window().maximize();
        else driver.manage().window().setSize(new Dimension(browserSize.getWidth(), browserSize.getHight()));
        return driver;
    }
}
