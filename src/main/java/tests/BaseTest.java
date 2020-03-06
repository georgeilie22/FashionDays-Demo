package tests;

import core.BuildBrowser;
import core.Config;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static core.BuildBrowser.WEBSITE;

public class BaseTest {

    BuildBrowser browser = new BuildBrowser(Config.getBrowserType());
    WebDriver driver = browser
            .withSize(Config.getSize())
            .isHeadless(Config.getHeadless())
            .build();

    @Test
    public void testTest() {
        driver.get(WEBSITE);
    }
}
