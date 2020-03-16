package tests;

import core.dataproviders.LoginDataProvider;
import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.LoginPage;
import pageobject.MyAccountPage;

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


    @Test(dataProvider = "invalidlogin", dataProviderClass = LoginDataProvider.class)
    public void invalidLoginTest(String user, String pass) {
        homepage = new Homepage(driver)
                .allowNotifications();
        loginPage = homepage
                .getToLoginPage()
                .invalidLogin(user, pass);

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
