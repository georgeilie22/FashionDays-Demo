package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Header {


    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[data-target='men']")
    private WebElement selectManButton;

    public CampainsPage goToManPage() {
        SeleniumUtils.waitForElementAndClick(5,selectManButton);
        return new CampainsPage(driver);
    }
}
