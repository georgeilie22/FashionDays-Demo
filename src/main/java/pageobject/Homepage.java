package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage extends Header {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "onesignal-popover-allow-button")
    WebElement allowNotificationButton;


    public LoginPage getToLoginPage() {
        SeleniumUtils.waitForElementToBeClickable(5, accountButton);
        return new LoginPage(driver);
    }

    public Homepage allowNotifications() {
        SeleniumUtils.waitForElementToBeClickable(5, allowNotificationButton);
        return new Homepage(driver);
    }


}
