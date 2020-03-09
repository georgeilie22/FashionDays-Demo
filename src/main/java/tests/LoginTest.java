package tests;

import core.BuildBrowser;
import core.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.MyAccountPage;

import java.util.concurrent.TimeUnit;

import static core.BuildBrowser.WEBSITE;

public class LoginTest {

    BuildBrowser browser;
    WebDriver driver;
    Homepage homepage;

    @BeforeMethod
    public void beforeTest() throws InterruptedException {
        browser = new BuildBrowser(Config.getBrowserType());
        driver = browser
                .withSize(Config.getSize())
                .isHeadless(Config.getHeadless())
                .build();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(WEBSITE);
        Thread.sleep(1000);
        driver.findElement(By.id("onesignal-popover-allow-button")).click();
        Thread.sleep(1000);
    }

    @Test
    public void validLoginTest() {
        homepage = new Homepage(driver)
                .getToLoginPage()
                .validLogin();
       new MyAccountPage(driver).assertAccountPage();

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
