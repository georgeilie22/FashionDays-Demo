package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BaseObject {


    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#customer-account")
    protected WebElement accountButton;

    @FindBy(css = "#customer-support")
    protected WebElement customerSupportButton;

    @FindBy(css = "#wishlist-top-menu")
    protected WebElement wishlistButton;

    @FindBy(css = "#customer-basket")
    protected WebElement cartButton;

    @FindBy(css = "#search-input")
    protected WebElement searchBar;

    @FindBy(css = "#onesignal-popover-allow-button")
    private WebElement allowNotificationButton;

    @FindBy(css = "#logo-link")
    private WebElement logoButton;

    public CartPage goToCart() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementAndClick(5, cartButton);
        return new CartPage(driver);
    }

    public void allowNotifications() {
        SeleniumUtils.waitForElementAndClick(5, allowNotificationButton);
    }

    public CampainsPage goToCampainsPage() {
        SeleniumUtils.waitForElementAndClick(5, logoButton);
        return new CampainsPage(driver);
    }
}
