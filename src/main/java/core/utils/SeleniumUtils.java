package core.utils;

import core.BuildBrowser;
import core.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtils {

    private static WebDriver driver;

    public static WebDriver buildDriver() {
        BuildBrowser browser = new BuildBrowser(Config.getBrowserType());
        driver = browser
                .withSize(Config.getSize())
                .isHeadless(Config.getHeadless())
                .build();
        return driver;
    }

    public static void waitForElementAndClick(int seconds, WebElement element) {
        new WebDriverWait(driver, seconds).until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static void waitForElementToBeVisible(int seconds, WebElement element){
        new WebDriverWait(driver, seconds).until(ExpectedConditions.visibilityOf(element));
    }

    public static void staticWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
