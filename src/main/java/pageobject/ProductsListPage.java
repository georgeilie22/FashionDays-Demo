package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductsListPage extends  Header {
    public ProductsListPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> products= driver.findElements(By.cssSelector("span.campaign-photo"));


    public ProductPage clickOnRandomProduct(){
        int randomNumber = RandomNumberGenerator.generateNumber(0, products.size()-1);
        System.out.println(randomNumber);
        SeleniumUtils.waitForElementAndClick(5,products.get(randomNumber));
        return new ProductPage(driver);
    }
}
