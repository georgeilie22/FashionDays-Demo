package pageobject;

import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CartPage extends Header {


    public CartPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> trashIconsList =
            driver.findElements(By.cssSelector("a[class='remove-from-cart icon-fd-trash']"));

    @FindBy(css = "div[data-prodid")
    private WebElement cartProductId;

    @FindBy(css = "div.cart-item-description > a")
    private WebElement baksetProductName;

    @FindBy(css = "#empty-cart-popup-close")
    private WebElement closeCartButton;

    public void checkProductInCart(String product) {
        SeleniumUtils.waitForElementToBeVisible(5, baksetProductName);
        Assert.assertEquals(baksetProductName.getText(), product);
    }


    public CartPage checkProductId(String productId) {
        SeleniumUtils.waitForElementToBeVisible(5, cartProductId);
        Assert.assertTrue(cartProductId.getAttribute("data-prodid").equals(productId) ||
                productId.equalsIgnoreCase("This item does not have an id"));
        return new CartPage(driver);
    }

    public CartPage deleteEveryProductFromCart() {
        for (int itemIndex = 0; itemIndex < trashIconsList.size(); itemIndex++) {
            SeleniumUtils.waitForElementAndClick(5, trashIconsList.get(itemIndex));
        }
        return new CartPage(driver);
    }

    public void closeTheCart() {
        SeleniumUtils.waitForElementAndClick(5, closeCartButton);
    }
}
