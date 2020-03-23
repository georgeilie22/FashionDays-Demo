package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class ProductPage extends Header {
    ProductPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> clothesSizes = driver.findElements(By.cssSelector("label[class='sizeSelector btn btn-block btn-default po-link']"));
    List<WebElement> shoesSize = driver.findElements(By.cssSelector("label[class='sizeSelector btn btn-block btn-default po-link  ']"));

    @FindBy(id = "buy-box")
    private WebElement addToCartButton;

    @FindBy(id = "tab_about_the_brand")
    private WebElement productBrandName;

    @FindBy(css = "h1.product-brand-desc")
    private WebElement productDetailedName;

    @FindBy(id = "customer-basket")
    private WebElement basketButton;

    @FindBy(css = "div.cart-item-description > a")
    private WebElement baksetProductName;


    public ProductPage addToCart() {
        SeleniumUtils.waitForElementAndClick(5, addToCartButton);
        return new ProductPage(driver);
    }

    public ProductPage selectRandomSize() {
        SeleniumUtils.staticWait(3);
        try {
            try {
                int randomNumber = RandomNumberGenerator.generateNumber(0, clothesSizes.size());
                SeleniumUtils.waitForElementAndClick(5, clothesSizes.get(randomNumber));
            } catch (Exception e) {
                e.printStackTrace();
                int randomNumber2 = RandomNumberGenerator.generateNumber(0, shoesSize.size());
                SeleniumUtils.waitForElementAndClick(5, shoesSize.get(randomNumber2));
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("The product don't have sizes");
        }

        return new ProductPage(driver);
    }

    public ProductPage checkProductInTheCartMatch() {
        String fullProductName = productBrandName.getText() + "\n" + productDetailedName.getText();
        SeleniumUtils.waitForElementAndClick(5, basketButton);
        SeleniumUtils.waitForElementToBeVisible(5, baksetProductName);
        System.out.println("Product in the basket: " + baksetProductName.getText() + "\n*****is equal to*****\n"
                + "Product that was added in the Basket: " + fullProductName);
        Assert.assertEquals(baksetProductName.getText(), fullProductName);
        return new ProductPage(driver);
    }
}
