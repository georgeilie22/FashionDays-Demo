package tests;

import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.ProductPage;
import pageobject.ProductsListPage;

import static core.BuildBrowser.WEBSITE;

public class AddProductToCart {


    WebDriver driver;
    Homepage homepage;
    ProductsListPage productsListPage;
    ProductPage productPage;


    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(WEBSITE);
    }

    @Test(invocationCount = 20)
    public void addProductToCart() {
        homepage = new Homepage(driver)
                .allowNotifications()
                .goToManPage();
        productsListPage = homepage
                .clickOnRandomCampain();
        productPage= productsListPage
                .clickOnRandomProduct()
                .selectRandomSize()
                .addToCart()
                .checkProductInTheCartMatch();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
