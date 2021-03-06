package tests;

import core.dataproviders.LoginDataProvider;
import core.enums.LoginErrorsEnum;
import core.utils.SeleniumUtils;
import core.utils.URLUtil;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.CampainsPage;
import pageobject.Header;
import pageobject.LoginPage;

public class LoginTest {


    WebDriver driver;
    CampainsPage campainsPage;
    LoginPage loginPage;


    @BeforeMethod
    public void beforeTest() {
        driver = SeleniumUtils.buildDriver();
        driver.get(URLUtil.getURL());
        new Header(driver).allowNotifications();
    }

    @Test
    public void validLoginTest() {
        campainsPage = new CampainsPage(driver)
                .goToLoginPage()
                .validLogin();
        campainsPage.assertUserLoggedIn();

    }


    @Test(dataProvider = "invalidEmails", dataProviderClass = LoginDataProvider.class)
    public void invalidEmailsLoginTest(String user, String pass) {
        campainsPage = new CampainsPage(driver);
        loginPage = campainsPage
                .goToLoginPage()
                .invalidLogin(user, pass)
                .assertLoginError(LoginErrorsEnum.INVALID_EMAIL);

    }

    @Test(dataProvider = "validEmails", dataProviderClass = LoginDataProvider.class)
    public void validEmailsLoginTest(String user, String pass) {
        campainsPage = new CampainsPage(driver);
        loginPage = campainsPage
                .goToLoginPage()
                .invalidLogin(user, pass)
                .assertLoginError(LoginErrorsEnum.VALID_EMAIL);

    }

    @Test(dataProvider = "emptyEmails", dataProviderClass = LoginDataProvider.class)
    public void emptyEmailsLoginTest(String user, String pass) {
        campainsPage = new CampainsPage(driver);
        loginPage = campainsPage
                .goToLoginPage()
                .invalidLogin(user, pass)
                .assertLoginError(LoginErrorsEnum.EMPTY_EMAIL);

    }

    @Test(dataProvider = "emptyPasswords", dataProviderClass = LoginDataProvider.class)
    public void emptyPasswordLogInTest(String user, String pass) {
        campainsPage = new CampainsPage(driver);
        loginPage = campainsPage
                .goToLoginPage()
                .invalidLogin(user, pass)
                .assertLoginError(LoginErrorsEnum.EMPTY_PASSWORD);
    }


    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
