package pageobject;

import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CampainsPage extends Header {

    public CampainsPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> campains = driver.findElements(By.cssSelector("li[id*='campaign-']"));


    public LoginPage getToLoginPage() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementAndClick(5, accountButton);
        return new LoginPage(driver);
    }

    public ProductsListPage clickOnRandomCampain() {
        int randomNumber = RandomNumberGenerator.generateNumber(0, campains.size() - 1);
        System.out.println(randomNumber);
        SeleniumUtils.waitForElementAndClick(5, campains.get(randomNumber));
        return new ProductsListPage(driver);
    }

}
