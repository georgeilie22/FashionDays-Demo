package tests;

import core.dataproviders.LoginDataProvider;
import core.enums.LoginErrorsEnum;
import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.LoginPage;
import pageobject.MyAccountPage;
import pageobject.ProductPage;

import static core.BuildBrowser.WEBSITE;

public class LoginTest {


    WebDriver driver;
    Homepage homepage;
    LoginPage loginPage;


    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(WEBSITE);
    }

    @Test
    public void validLoginTest() {
        homepage = new Homepage(driver)
                .allowNotifications()
                .getToLoginPage()
                .validLogin();
        new MyAccountPage(driver).assertAccountPage();

    }


    @Test(dataProvider = "invalidEmails", dataProviderClass = LoginDataProvider.class)
    public void invalidEmailsLoginTest(String user, String pass) {
        homepage = new Homepage(driver)
                .allowNotifications();
        loginPage = homepage
                .getToLoginPage()
                .invalidLogin(user, pass)
                .AssertLoginError(LoginErrorsEnum.INVALID_EMAIL);

    }

    @Test(dataProvider = "validEmails", dataProviderClass = LoginDataProvider.class)
    public void validEmailsLoginTest(String user, String pass) {
        homepage = new Homepage(driver)
                .allowNotifications();
        loginPage = homepage
                .getToLoginPage()
                .invalidLogin(user, pass)
                .AssertLoginError(LoginErrorsEnum.VALID_EMAIL);

    }

    @Test(dataProvider = "emptyEmails", dataProviderClass = LoginDataProvider.class)
    public void emptyEmailsLoginTest(String user, String pass) {
        homepage = new Homepage(driver)
                .allowNotifications();
        loginPage = homepage
                .getToLoginPage()
                .invalidLogin(user, pass)
                .AssertLoginError(LoginErrorsEnum.EMPTY_EMAIL);

    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
