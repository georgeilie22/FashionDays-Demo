package pageobject;

import core.CredentialsJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Header {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(id = "pizokel_customer_submit")
    private WebElement submitbutton;


    public Homepage validLogin() {
        emailField.sendKeys(CredentialsJson.getCredential("validemail"));
        passwordField.sendKeys(CredentialsJson.getCredential("validpassword"));
        submitbutton.click();
        return new Homepage(driver);
    }

}
