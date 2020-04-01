package tests;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;

import static core.BuildBrowser.WEBSITE;

public class AddProductToCart {


    WebDriver driver;
    ProductPage productPage;
    HomePage homePage;


    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(WEBSITE);
        homePage = new HomePage(driver);
        homePage.allowNotifications();
        homePage.goToCart()
                .deleteEveryProductFromCart()
                .closeTheCart();

    }

    @Test(invocationCount = 1)
    public void addProductToCartNotLoggedIn() {
        productPage = homePage
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();
        String productName = productPage.getProductName();
        productPage.goToCart()
                .checkProductInCart(productName);
    }

    @Test
    public void addProductToCartLoggedIn() {
        new CampainsPage(driver)
                .getToLoginPage()
                .validLogin();
        new MyAccountPage(driver)
                .assertAccountPage()
                .goToCampainsPage();
        productPage = homePage
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();
        String productName = productPage.getProductName();
        productPage.goToCart()
                .checkProductInCart(productName);
    }

    @AfterMethod
    public void tearDown() {
        new CartPage(driver)
                .deleteEveryProductFromCart()
                .closeTheCart();
        driver.close();
    }
}
