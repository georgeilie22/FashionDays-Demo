package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BaseObject{


    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer-account")
    protected WebElement accountButton;

    @FindBy(id = "customer-support")
    protected WebElement customerSupportButton;

    @FindBy(id = "wishlist-top-menu")
    protected WebElement wishlistButton;

    @FindBy(id = "customer-basket")
    protected WebElement cartButton;

    @FindBy(id = "search-input")
    protected WebElement searchBar;

    @FindBy(id = "onesignal-popover-allow-button")
    private WebElement allowNotificationButton;

    @FindBy(id = "logo-link")
    private WebElement logoButton;

    public CartPage goToCart() {
        SeleniumUtils.waitForElementAndClick(5, cartButton);
        return new CartPage(driver);
    }

    public void allowNotifications() {
        SeleniumUtils.waitForElementAndClick(5, allowNotificationButton);
    }

    public CampainsPage goToCampainsPage(){
        SeleniumUtils.waitForElementAndClick(5,logoButton);
        return new CampainsPage(driver);
    }
}
