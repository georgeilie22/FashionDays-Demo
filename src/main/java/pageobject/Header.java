package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Header extends BaseObject {


    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#customer-account")
    protected WebElement accountButton;

    @FindBy(css = "#my-account-dropdown")
    protected WebElement accountDropdown;

    @FindBy(css = "#customer-support")
    protected WebElement customerSupportButton;

    @FindBy(css = "#wishlist-top-menu")
    protected WebElement wishlistButton;

    @FindBy(css = "#customer-basket")
    protected WebElement cartButton;

    @FindBy(css = "#search-input")
    protected WebElement searchBar;

    @FindBy(css = "#onesignal-popover-allow-button")
    protected WebElement allowNotificationButton;

    @FindBy(css = "#logo-link")
    protected WebElement logoButton;

    @FindBy(css = "#my-account-dropdown > ul > li:nth-child(9) > a")
    protected WebElement logoutButton;

    public CartPage goToCart() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementAndClick(5, cartButton);
        return new CartPage(driver);
    }

    public void allowNotifications() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementAndClick(5, allowNotificationButton);
    }

    public CampainsPage goToCampainsPage() {
        SeleniumUtils.waitForElementAndClick(5, logoButton);
        return new CampainsPage(driver);
    }

    public void assertUserLoggedIn() {
        SeleniumUtils.waitForElementToBeVisible(5, accountDropdown);
        SeleniumUtils.moveToObject(driver, accountDropdown);
        Assert.assertEquals(logoutButton.getText(), "Logout");
    }

    public void logOut(){
        SeleniumUtils.waitForElementToBeVisible(5, accountDropdown);
        SeleniumUtils.moveToObject(driver, accountDropdown);
        SeleniumUtils.waitForElementAndClick(5,logoutButton);
    }

    public LoginPage getToLoginPage() {
        SeleniumUtils.staticWait(2);
        SeleniumUtils.waitForElementAndClick(5, accountButton);
        return new LoginPage(driver);
    }
}
