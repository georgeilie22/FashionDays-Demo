package pageobject;

import com.google.common.truth.Truth;
import core.CredentialsJson;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(xpath = "(//div[@class='error-message'])[1]")
    private WebElement emailErrorMessage;

    @FindBy(xpath = "(//div[@class='error-message'])[2]")
    private WebElement passwordErrorMessage;

    public Homepage validLogin() {
        emailField.sendKeys(CredentialsJson.getCredential("validemail"));
        passwordField.sendKeys(CredentialsJson.getCredential("validpassword"));
        submitbutton.click();
        return new Homepage(driver);
    }

    public LoginPage invalidLogin(String user, String password){
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        submitbutton.click();
        return new LoginPage(driver);
    }

    public LoginPage AssertLoginError(){
        return new LoginPage(driver);
    }

}
