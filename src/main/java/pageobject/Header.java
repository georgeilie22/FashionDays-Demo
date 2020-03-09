package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Header extends BaseObject{


    Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "customer-account")
    protected WebElement accountButton;

    @FindBy(id = "customer-support")
    protected WebElement customerSupportButton;

    @FindBy(id = "wishlist-top-menu")
    protected WebElement wishlistButton;

    @FindBy(id = "customer-basket")
    protected WebElement basketButton;

    @FindBy(id = "search-input")
    protected WebElement searchBar;



}
