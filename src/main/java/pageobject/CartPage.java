package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends Header {


    public CartPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(css = "a[class='remove-from-cart icon-fd-trash']")
    private List<WebElement> trashIconsList;

    @FindBy(css = "a[class='remove-from-cart icon-fd-trash']")
    private WebElement trashIcon;

    @FindBy(css = "div[data-prodid")
    private List<WebElement> cartProductIdList;

    @FindBy(css = "div[data-prodid")
    private WebElement cartProductId;

    @FindBy(css = "div.cart-item-description > a")
    private WebElement baksetProductName;

    @FindBy(css = "div.cart-item-description > a")
    private List<WebElement> baksetProductNameList;

    @FindBy(css = "#empty-cart-popup-close")
    private WebElement closeCartButton;

    @FindBy(css = "button[name='qty']")
    private WebElement quantityDropdown;

    @FindBy(css = ".dropdown-menu >li")
    private List<WebElement> quantityList;

    @FindBy(css = ".cart-item-subtotal-price > span")
    private WebElement price;

    @FindBy(css = "#cartProceedCheckout")
    private WebElement nextStepButton;


    public CartPage checkProductInCart(String product) {
        SeleniumUtils.staticWait(1);
        Assert.assertEquals(baksetProductName.getText(), product);

        return new CartPage(driver);
    }

    public CartPage checkProductsInCart(ArrayList product) {
        SeleniumUtils.staticWait(1);
        for (int i = 0; i < baksetProductNameList.size(); i++) {
            Assert.assertTrue(product.contains(baksetProductNameList.get(i).getText()));
        }

        return new CartPage(driver);
    }

    public CartPage checkProductId(String productId) {
        SeleniumUtils.staticWait(1);
        Assert.assertTrue(cartProductId.getAttribute("data-prodid").equals(productId) ||
                productId.equals("This item does not have an id"));

        return new CartPage(driver);
    }

    public CartPage checkProductIds(ArrayList productId) {
        SeleniumUtils.staticWait(1);
        for (int i = 0; i < cartProductIdList.size(); i++) {
            Assert.assertTrue(productId.contains(cartProductIdList.get(i).getAttribute("data-prodid"))
                    || productId.contains("This item does not have an id"));
        }

        return new CartPage(driver);
    }


    public CartPage deleteEveryProductFromCart() {
        SeleniumUtils.staticWait(1);
        for (int itemIndex = 0; itemIndex < trashIconsList.size(); itemIndex++) {
            SeleniumUtils.waitForElementAndClick(5, trashIconsList.get(itemIndex));
        }
        return new CartPage(driver);
    }

    public CartPage deleteRandomProductFromCart() {
        int randomNumber = RandomNumberGenerator.generateNumber(1, trashIconsList.size() - 1);
        SeleniumUtils.waitForElementAndClick(5, trashIconsList.get(randomNumber));

        return new CartPage(driver);
    }

    public int saveNumberOfProductsPresent() {
        SeleniumUtils.waitForElementToBeVisible(5, trashIcon);
        return trashIconsList.size();
    }

    public CartPage checkTheNewNumberProducts(int previousNumber) {
        SeleniumUtils.staticWait(1);
        Assert.assertTrue(previousNumber > trashIconsList.size());

        return new CartPage(driver);
    }

    public void closeTheCart() {
        SeleniumUtils.waitForElementAndClick(5, closeCartButton);
    }


    public CartPage selectRandomQuantity() {
        SeleniumUtils.waitForElementAndClick(5, quantityDropdown);
        int randomNumber = RandomNumberGenerator.generateNumber(0, quantityList.size() - 1);
        SeleniumUtils.waitForElementAndClick(5, quantityList.get(randomNumber));

        return new CartPage(driver);
    }

    public CartPage selectMinimumQuantity() {
        SeleniumUtils.waitForElementAndClick(5, quantityDropdown);
        SeleniumUtils.waitForElementAndClick(5, quantityList.get(0));

        return new CartPage(driver);
    }

    public CartPage selectMaxQuantity() {
        SeleniumUtils.waitForElementAndClick(5, quantityDropdown);
        SeleniumUtils.waitForElementAndClick(5, quantityList.get((quantityList.size() - 1)));

        return new CartPage(driver);
    }

    public String savePriceValue() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementToBeVisible(5, price);

        return price.getText();
    }

    public CartPage checkPriceUpdate(String firstPrice, String updatedPrice) {
        if (quantityList.size() == 1) {
            System.out.println("Only one product is available.");
        } else {
            Assert.assertNotEquals(updatedPrice, firstPrice);
        }
        return new CartPage(driver);
    }

    public CheckoutPage addProductToCartAndgetToTheCheckoutPage() {
        ProductPage productPage;
        HomePage homePage = new HomePage(driver);

        homePage.goToLoginPage()
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
        SeleniumUtils.waitForElementAndClick(5, nextStepButton);

        return new CheckoutPage(driver);
    }

    public CheckoutPage goToCheckoutPage(){
        SeleniumUtils.waitForElementAndClick(5, nextStepButton);

        return new CheckoutPage(driver);
    }

    public CartPage assertEmptyCart(){
        SeleniumUtils.staticWait(1);
        Assert.assertEquals(trashIconsList.size(),0);

        return new CartPage(driver);
    }

}
