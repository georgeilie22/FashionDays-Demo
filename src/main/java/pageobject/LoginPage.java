package pageobject;

import core.CredentialsJson;
import core.enums.LoginErrorsEnum;
import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends Header {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static String INCORECT_EMAIL_PASSWORD = "Adresa de email sau parola este incorecta." +
            " Te rugam sa introduci o alta combinatie.";
    private static String INVALID_EMAIL = "Adresa de email este invalida.";
    private static String EMPTY_FIELD = "Acest camp este obligatoriu";

    @FindBy(css = "#email")
    private WebElement emailField;

    @FindBy(css = "#password")
    private WebElement passwordField;

    @FindBy(css = "#pizokel_customer_submit")
    private WebElement submitbutton;

    @FindBy(css = ".email-input-field > div")
    private WebElement emailErrorMessage;

    @FindBy(css = "div.js-form-input-container:nth-child(2) > div:nth-child(4)")
    private WebElement passwordErrorMessage;

    public CampainsPage validLogin() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementToBeVisible(5,emailField);
        emailField.sendKeys(CredentialsJson.getCredential("validemail"));
        SeleniumUtils.waitForElementToBeVisible(5,passwordField);
        passwordField.sendKeys(CredentialsJson.getCredential("validpassword"));
        SeleniumUtils.waitForElementAndClick(5,submitbutton);
        return new CampainsPage(driver);
    }

    public LoginPage invalidLogin(String user, String password) {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementToBeVisible(5,emailField);
        emailField.sendKeys(user);
        SeleniumUtils.waitForElementToBeVisible(5,passwordField);
        passwordField.sendKeys(password);
        SeleniumUtils.waitForElementAndClick(5,submitbutton);
        return new LoginPage(driver);
    }

    public LoginPage AssertLoginError(LoginErrorsEnum errorsEnum) {

        switch (errorsEnum) {
            case EMPTY_EMAIL:
                Assert.assertEquals(emailErrorMessage.getText(), EMPTY_FIELD);
                break;
            case VALID_EMAIL:
                Assert.assertEquals(emailErrorMessage.getText(), INCORECT_EMAIL_PASSWORD);
                break;
            case INVALID_EMAIL:
                Assert.assertEquals(emailErrorMessage.getText(), INVALID_EMAIL);
                break;
            case EMPTY_PASSWORD:
                Assert.assertEquals(passwordErrorMessage.getText(), EMPTY_FIELD);
        }

        return new LoginPage(driver);
    }

}
