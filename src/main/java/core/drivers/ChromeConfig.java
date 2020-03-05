package core.drivers;

import core.enums.BrowserEnum;
import core.enums.SizeEnum;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeConfig implements DriversConfig {

    boolean headlessValue;
    SizeEnum browserSize;

    @Override
    public DriversConfig isHeadless(boolean bool) {
        headlessValue= bool;
      return this;

    }

    @Override
    public DriversConfig withSize(SizeEnum size) {
        browserSize =size;
        return this;
    }

    @Override
    public WebDriver build() {
        System.setProperty(BrowserEnum.CHROME.getKey(),BrowserEnum.CHROME.getPath());
        ChromeOptions chromeOptions= new ChromeOptions();
        if (headlessValue) chromeOptions.setHeadless(true);
        WebDriver driver= new ChromeDriver(chromeOptions);
        if (browserSize==SizeEnum.MAX) driver.manage().window().maximize();
        else driver.manage().window().setSize(new Dimension(browserSize.getWidth(), browserSize.getHight()));
        return driver;
    }
}
