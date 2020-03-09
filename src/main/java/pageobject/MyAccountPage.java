package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends Header {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='full-site-canvas']/div[3]/div/div/h1")
    protected WebElement myAccountTextAssert;

    public MyAccountPage assertAccountPage() {
        accountButton.click();
        Assert.assertEquals(myAccountTextAssert.getText(), "CONTUL MEU");
        return new MyAccountPage(driver);
    }
}
