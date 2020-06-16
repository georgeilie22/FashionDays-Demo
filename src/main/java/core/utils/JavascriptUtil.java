package core.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {

    JavascriptExecutor javascriptExecutor;

    public JavascriptUtil(WebDriver driver) {
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void click(WebElement element) {
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

}
