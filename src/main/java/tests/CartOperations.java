package tests;

import core.utils.SeleniumUtils;
import core.utils.URLUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.*;


public class CartOperations {

    WebDriver driver;
    ProductPage productPage;
    CartPage cartPage;

    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(URLUtil.getURL());
        new Header(driver).allowNotifications();
    }

    @Test()
    public void increaseProductQuantity() {
        productPage = new HomePage(driver)
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();
        cartPage = productPage.goToCart();

        String initialPrice = cartPage.savePriceValue();

        cartPage.selectMaxQuantity();

        String updatedPrice = cartPage.savePriceValue();

        cartPage.checkPriceUpdate(initialPrice, updatedPrice);

    }

    @Test()
    public void decreaseProductQuantity() {
        productPage = new HomePage(driver)
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();
        cartPage = productPage
                .goToCart()
                .selectMaxQuantity();
        String inceasedPrice = cartPage.savePriceValue();

        cartPage.selectMinimumQuantity();

        String decreasedPrice = cartPage.savePriceValue();

        cartPage.checkPriceUpdate(inceasedPrice, decreasedPrice);

    }

    @Test
    public void deleteProductFromTheCart() {
        productPage = new HomePage(driver)
                .goToManPage()
                .clickOnRandomCampain()
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();
        driver.navigate().back();
        new ProductsListPage(driver)
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart();

        cartPage = productPage
                .goToCart();

        int numberOfProductsInCart = cartPage.saveNumberOfProductsPresent();

        cartPage.deleteRandomProductFromCart()
                .checkTheNewNumberProducts(numberOfProductsInCart);
    }


    @AfterMethod
    public void tearDown() {
        new CartPage(driver)
                .deleteEveryProductFromCart()
                .closeTheCart();
        driver.close();
    }
}


    

