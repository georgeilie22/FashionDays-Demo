package tests;

import core.utils.SeleniumUtils;
import core.utils.URLUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;

import java.util.ArrayList;

public class AddProductToCart {


    WebDriver driver;
    ProductPage productPage;
    HomePage homePage;
    CampainsPage campainsPage;


    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(URLUtil.getURL());
        homePage = new HomePage(driver);
        homePage.allowNotifications();
        homePage.goToCart()
                .deleteEveryProductFromCart()
                .closeTheCart();

    }

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void addProductToCartAndCheckProuctIds() {
        productPage = homePage
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct();

        String productId = productPage.selectRandomSizeAndGetItemId();

        productPage.addToCart()
                .goToCart()
                .checkProductId(productId);
    }
    
    //TODO checkout operations / add adress/ cleanup/
    @Test(priority = 3)
    public void addProductToCartLoggedIn() {
        new Header(driver)
                .getToLoginPage()
                .validLogin()
                .assertUserLoggedIn();
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

    @Test(priority = 4)
    public void addTwoProductsToCartLoggedInAndNotLoggedIn() {
        new Header(driver)
                .getToLoginPage()
                .validLogin()
                .assertUserLoggedIn();
        productPage = homePage
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();

        ArrayList<String> productNamesArray = new ArrayList<>();
        productNamesArray.add(productPage.getProductName());

        productPage.logOut();

        new CampainsPage(driver)
                .goToCampainsPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();
        productNamesArray.add(productPage.getProductName());

        productPage
                .getToLoginPage()
                .validLogin();
        new CartPage(driver)
                .checkProductsInCart(productNamesArray);

    }

    @AfterMethod
    public void tearDown() {
        new CartPage(driver)
                .deleteEveryProductFromCart()
                .closeTheCart();
        driver.close();
    }
}
