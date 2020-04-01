package pageobject;

import core.CredentialsJson;
import core.enums.LoginErrorsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends Header {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static String INCORECT_EMAIL_PASSWORD="Adresa de email sau parola este incorecta." +
            " Te rugam sa introduci o alta combinatie.";
    private static String INVALID_EMAIL= "Adresa de email este invalida.";
    private static String EMPTY_FIELD= "Acest camp este obligatoriu";

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

    public CampainsPage validLogin() {
        emailField.sendKeys(CredentialsJson.getCredential("validemail"));
        passwordField.sendKeys(CredentialsJson.getCredential("validpassword"));
        submitbutton.click();
        return new CampainsPage(driver);
    }

    public LoginPage invalidLogin(String user, String password) {
        emailField.sendKeys(user);
        passwordField.sendKeys(password);
        submitbutton.click();
        return new LoginPage(driver);
    }

    public LoginPage AssertLoginError(LoginErrorsEnum errorsEnum) {

        switch (errorsEnum){
            case EMPTY_EMAIL: Assert.assertEquals(emailErrorMessage.getText(),EMPTY_FIELD);
            break;
            case VALID_EMAIL: Assert.assertEquals(emailErrorMessage.getText(),INCORECT_EMAIL_PASSWORD);
            break;
            case INVALID_EMAIL: Assert.assertEquals(emailErrorMessage.getText(),INVALID_EMAIL);
            break;
        }

        return new LoginPage(driver);
    }

}
