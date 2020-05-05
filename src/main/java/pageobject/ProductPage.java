package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Header {
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    private static String DROPDOWN_CSS = "multiple-buttons radio-buttons dropdown";

    @FindBy(css = "div[class*='radio-buttons'] > div > div > label:not([class*='disabled'])")
    private List<WebElement> sizeList;

    @FindBy(css = "div[class*='radio-buttons']")
    private WebElement dropDropdownSelector;

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
        if (sizeList.size() > 0) {
            SeleniumUtils.waitForElementAndClick(5, sizeDropdown);
            int randomNumber = RandomNumberGenerator.generateNumber(0, sizeList.size() - 1);
            SeleniumUtils.waitForElementAndClick(5, sizeList.get(randomNumber));
            String itemId = sizeList.get(randomNumber).getAttribute("data-productid");
            return itemId;
        } else return "This item does not have an id";
    }

    public String selectRandomSizeFormButtons() {
        if (sizeList.size() > 0) {
            int randomNumber = RandomNumberGenerator.generateNumber(0, sizeList.size() - 1);
            SeleniumUtils.waitForElementAndClick(5, sizeList.get(randomNumber));
            String itemId = sizeList.get(randomNumber).getAttribute("data-productid");
            return itemId;
        } else return "This item does not have an id";
    }

    public String selectRandomSizeAndGetItemId() {
        try {
            if (dropDropdownSelector.getAttribute("class").equalsIgnoreCase(DROPDOWN_CSS)) {
                return selectRandomSizeFromDropdown();
            } else return selectRandomSizeFormButtons();
        }
        catch (NoSuchElementException e){
            e.printStackTrace();
            return "This item does not have an id";
        }
    }

    public ProductPage selectRandomSize() {
        SeleniumUtils.staticWait(3);

        if (sizeList.size() <= 0) {
            System.out.println("The product don't have sizes");
        } else if (dropDropdownSelector.getAttribute("class").equalsIgnoreCase(DROPDOWN_CSS)) {
            selectRandomSizeFromDropdown();
        } else selectRandomSizeFormButtons();

        return new ProductPage(driver);
    }

    public String getProductName() {
        return productBrandName.getText() + "\n" + productDetailedName.getText();
    }
}
