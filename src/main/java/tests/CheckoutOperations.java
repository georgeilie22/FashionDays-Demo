package tests;

import core.utils.SeleniumUtils;
import core.utils.URLUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.CartPage;
import pageobject.CheckoutPage;
import pageobject.Header;

public class CheckoutOperations {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(URLUtil.getURL());
        new Header(driver).allowNotifications();
    }

    @Test
    public void getToCheckout() {
        checkoutPage = new CartPage(driver)
                .getToTheCheckoutPage()
                .assertCheckoutPage();
    }

    @Test
    public void selectDeliveryOption() {
        checkoutPage = new CartPage(driver)
                .getToTheCheckoutPage()
                .assertCheckoutPage()
                .selectRandomDeliveryOptions()
                .fillDeliveryInfo();
    }

    @AfterMethod
    public void teardown() {
        new CheckoutPage(driver)
                .goToCampainsPage()
                .goToCart()
                .deleteEveryProductFromCart()
                .assertEmptyCart();
        driver.close();
    }
}
