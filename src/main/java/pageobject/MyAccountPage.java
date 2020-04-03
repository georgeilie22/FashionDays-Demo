package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends Header {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".my-account-title > h1")
    protected WebElement myAccountTextAssert;

    public MyAccountPage assertAccountPage() {
        SeleniumUtils.staticWait(1);
        accountButton.click();
        SeleniumUtils.waitForElementToBeVisible(5, myAccountTextAssert);
        Assert.assertEquals(myAccountTextAssert.getText(), "CONTUL MEU");
        return new MyAccountPage(driver);
    }
}
