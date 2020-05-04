package tests;

import core.utils.SeleniumUtils;
import core.utils.URLUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;

public class CheckoutOperations {

    WebDriver driver;
    CheckoutPage checkoutPage;

    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(URLUtil.getURL());
        new Header(driver).allowNotifications();
    }

    @Test(priority = 1)
    public void getToCheckout() {
        checkoutPage = new CartPage(driver)
                .addProductToCartAndgetToTheCheckoutPage()
                .assertCheckoutPage();
    }

    @Test(priority = 2)
    public void selectEasyBoxDelivery() {
        checkoutPage = new CartPage(driver)
                .addProductToCartAndgetToTheCheckoutPage()
                .assertCheckoutPage()
                .selectEasyBoxDeliveryOption()
                .fillEasyboxDeliveryInfo();
        String easyBoxName = checkoutPage.selectRandomPickupPointAndSaveTheName();
        checkoutPage.assertEasyBoxDeliveryInformation(easyBoxName);
    }

    @Test(priority = 3)
    public void selectStandardDelivery() {
        checkoutPage = new CartPage(driver)
                .addProductToCartAndgetToTheCheckoutPage()
                .assertCheckoutPage()
                .selectStandardDeliveryOptions()
                .fillNormalDeliveryInfo()
                .assertStandardDeliveryInformation();
    }

    @Test(priority = 4)
    public void checkIfProductIsCorrect() {
        new Header(driver)
                .goToLoginPage()
                .validLogin();

        ProductPage productPage = new HomePage(driver)
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();

        String selectedProduct = productPage.getProductName();

        productPage
                .goToCart()
                .checkProductInCart(selectedProduct)
                .goToCheckoutPage()
                .checkIfProductIsMatching(selectedProduct);

    }

    @Test(priority = 5)
    public void deletProductsFromCheckout() {
        checkoutPage = new CartPage(driver)
                .addProductToCartAndgetToTheCheckoutPage()
                .assertCheckoutPage();
        checkoutPage
                .deleteProduct();
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
