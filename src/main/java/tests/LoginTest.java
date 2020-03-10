package tests;

import com.google.gson.JsonObject;
import core.utils.JsonUtil;
import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageobject.Homepage;
import pageobject.MyAccountPage;

import static core.BuildBrowser.WEBSITE;

public class LoginTest {


    WebDriver driver;
    Homepage homepage;


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


    @DataProvider(name = "invalidlogindata")
    public static Object[] invaliddata() {
        JsonObject jsonObject = JsonUtil.getJson("src\\main\\java\\resources\\emails.json");
        
    }

    @Test
    public void invalidLoginTest(String user, String password) {
        homepage = new Homepage(driver)
                .allowNotifications()
                .getToLoginPage()
                .invalidLogin(user, password);
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
