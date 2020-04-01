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

    @FindBy(id = "buy-box")
    private WebElement addToCartButton;

    @FindBy(id = "tab_about_the_brand")
    private WebElement productBrandName;

    @FindBy(css = "h1.product-brand-desc")
    private WebElement productDetailedName;

    @FindBy(id = "sizeDrop")
    private WebElement sizeDropdown;


    public ProductPage addToCart() {
        SeleniumUtils.waitForElementAndClick(5, addToCartButton);
        return new ProductPage(driver);
    }
    

    public ProductPage selectRandomSizeFromDropdown() {
        SeleniumUtils.waitForElementAndClick(5, sizeDropdown);
        int randomNumber = RandomNumberGenerator.generateNumber(0, sizeDropdownList.size() - 1);
        SeleniumUtils.waitForElementAndClick(5, sizeDropdownList.get(randomNumber));
        return new ProductPage(driver);

    }

    public ProductPage selectRandomSizeFormButtons() {
        try {
            int randomNumber = RandomNumberGenerator.generateNumber(0, clothesSizesList.size() - 1);
            System.out.println("random nr is: " + randomNumber + "listSize is " + clothesSizesList.size());
            SeleniumUtils.waitForElementAndClick(5, clothesSizesList.get(randomNumber));
        } catch (Exception e) {
            int randomNumber2 = RandomNumberGenerator.generateNumber(0, shoesSizeList.size() - 1);
            System.out.println("random nr is: " + randomNumber2 + "listSize is " + shoesSizeList.size());

            SeleniumUtils.waitForElementAndClick(5, shoesSizeList.get(randomNumber2));
        }
        return new ProductPage(driver);
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

    //TODO Match product in cart by id
    public String getProductName() {
        return productBrandName.getText() + "\n" + productDetailedName.getText();
    }
}
