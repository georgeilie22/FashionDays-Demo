package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Homepage extends Header {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> campains = driver.findElements(By.cssSelector("li[id*='campaign-']"));

    @FindBy(id = "onesignal-popover-allow-button")
    private WebElement allowNotificationButton;

    @FindBy(xpath = "//a[@data-target='men']")
    private WebElement selectManButton;


    public LoginPage getToLoginPage() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementAndClick(5, accountButton);
        return new LoginPage(driver);
    }

    public Homepage allowNotifications() {
        SeleniumUtils.waitForElementAndClick(5, allowNotificationButton);
        return new Homepage(driver);
    }


    public Homepage goToManPage() {
        selectManButton.click();
        return new Homepage(driver);
    }

    public ProductsListPage clickOnRandomCampain() {
        int randomNumber = RandomNumberGenerator.generateNumber(0, campains.size());
        System.out.println(randomNumber);
        SeleniumUtils.waitForElementAndClick(5,campains.get(randomNumber));
        return new ProductsListPage(driver);
    }

}
