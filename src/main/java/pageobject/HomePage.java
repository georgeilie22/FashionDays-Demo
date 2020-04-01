package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  Header {


   public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@data-target='men']")
    private WebElement selectManButton;

    public CampainsPage goToManPage() {
        selectManButton.click();
        return new CampainsPage(driver);
    }
}
