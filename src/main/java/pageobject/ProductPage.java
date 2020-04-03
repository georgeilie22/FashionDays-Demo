package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Header {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    List<WebElement> clothesSizesList = driver.findElements(By.cssSelector("label[class='sizeSelector btn btn-block btn-default po-link']"));
    List<WebElement> shoesSizeList = driver.findElements(By.cssSelector("label[class='sizeSelector btn btn-block btn-default po-link  ']"));
    List<WebElement> sizeDropdownList = driver.findElements(By.cssSelector("label[class='sizeSelector btn btn-block btn-default po-link  ']  "));

    @FindBy(css = "#buy-box")
    private WebElement addToCartButton;

    @FindBy(css = "#tab_about_the_brand")
    private WebElement productBrandName;

    @FindBy(css = "h1.product-brand-desc")
    private WebElement productDetailedName;

    @FindBy(css = "#sizeDrop")
    private WebElement sizeDropdown;


    public ProductPage addToCart() {
        SeleniumUtils.waitForElementAndClick(5, addToCartButton);
        return new ProductPage(driver);
    }


    public String selectRandomSizeFromDropdown() {
        if (sizeDropdownList.size() > 0) {
            SeleniumUtils.waitForElementAndClick(5, sizeDropdown);
            int randomNumber = RandomNumberGenerator.generateNumber(0, sizeDropdownList.size() - 1);
            SeleniumUtils.waitForElementAndClick(5, sizeDropdownList.get(randomNumber));
            String itemId = shoesSizeList.get(randomNumber).getAttribute("data-productid");
            return itemId;
        } else return "This item does not have an id";
    }

    public String selectRandomSizeFormButtons() {
        if (clothesSizesList.size() > 0 || sizeDropdownList.size() > 0) {
            try {
                int randomNumber = RandomNumberGenerator.generateNumber(0, clothesSizesList.size() - 1);
                SeleniumUtils.waitForElementAndClick(5, clothesSizesList.get(randomNumber));
                String itemId = clothesSizesList.get(randomNumber).getAttribute("data-productid");
                return itemId;
            } catch (Exception e) {
                int randomNumber2 = RandomNumberGenerator.generateNumber(0, shoesSizeList.size() - 1);
                SeleniumUtils.waitForElementAndClick(5, shoesSizeList.get(randomNumber2));
                String itemId = shoesSizeList.get(randomNumber2).getAttribute("data-productid");
                return itemId;
            }
        } else return "This item does not have an id";
    }

    public String selectRandomSizeAndGetItemId() {
        try {
            return selectRandomSizeFromDropdown();
        } catch (Exception e) {
            return selectRandomSizeFormButtons();
        }
    }

    public ProductPage selectRandomSize() {
        SeleniumUtils.staticWait(3);

        try {
            try {
                selectRandomSizeFromDropdown();
            } catch (Exception ex) {
                selectRandomSizeFormButtons();
            }
        } catch (Exception e) {
            System.out.println("The product don't have sizes");
        }

        return new ProductPage(driver);
    }

    public String getProductName() {
        return productBrandName.getText() + "\n" + productDetailedName.getText();
    }
}
