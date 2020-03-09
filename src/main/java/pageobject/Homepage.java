package pageobject;

import org.openqa.selenium.WebDriver;

public class Homepage extends Header {

    public Homepage(WebDriver driver) {
        super(driver);
    }

    public LoginPage getToLoginPage() {
        accountButton.click();
        return new LoginPage(driver);
    }
}
