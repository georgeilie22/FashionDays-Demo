package pageobject;

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

    public void closeTheCart() {
        SeleniumUtils.waitForElementAndClick(5, closeCartButton);
    }
}
