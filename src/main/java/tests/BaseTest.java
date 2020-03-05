package tests;

import core.BuildBrowser;
import core.enums.BrowserEnum;
import core.enums.SizeEnum;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static core.BuildBrowser.WEBSITE;

public class BaseTest {

     BuildBrowser browser= new BuildBrowser(BrowserEnum.MOZILLA);
     WebDriver driver= browser
             .withSize(SizeEnum.MAX)
             .isHeadless(false)
             .build();

    @Test
    public void testTest(){
        driver.get(WEBSITE);
    }
}
