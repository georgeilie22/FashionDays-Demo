package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CampainsPage extends Header {

    public CampainsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> campains = driver.findElements(By.cssSelector("li[id*='campaign-']"));


    public ProductsListPage clickOnRandomCampain() {
        SeleniumUtils.staticWait(1);
        int randomNumber = RandomNumberGenerator.generateNumber(0, campains.size() - 1);
        SeleniumUtils.waitForElementAndClick(5, campains.get(randomNumber));
        return new ProductsListPage(driver);
    }

}
