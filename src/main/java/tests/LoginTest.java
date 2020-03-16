package tests;

import com.google.gson.JsonArray;
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


    @DataProvider(name= "invalidlogin")
    public Object[][] dataProviderMethod(){
        JsonObject emails= JsonUtil.getJson("src\\main\\resources\\emails.json");
        JsonArray emailArray= emails.getAsJsonArray("invalid_email_values");
        JsonObject passwords= JsonUtil.getJson("src\\main\\resources\\passwords.json");
        JsonArray passwrodsArray= passwords.getAsJsonArray("invalid_password_values");

        return new Object[][] {{emailArray.get(0).toString().replace("\"", "").toString()}};

    }

    @Test(dataProvider = "invalidlogin")
    public void invalidLoginTest(String user) {
        homepage = new Homepage(driver)
                .allowNotifications()
                .getToLoginPage()
                .invalidLogin(user, "12345");
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}
