package pageobject;

import com.google.gson.JsonObject;
import core.utils.JsonUtil;
import core.utils.RandomNumberGenerator;
import core.utils.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CheckoutPage extends Header {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    String deliveryOptionsExpectedText = "OPTIUNI LIVRARE";

    @FindBy(css = "section[class='bottom-shadow'] > header > :nth-child(2)")
    private WebElement deliveryOptionsText;

    @FindBy(css = "div.u-d-flex.container-a > ul > li")
    private List<WebElement> deliveryOptions;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > " +
            "div.form-input-group.first-name-group > input")
    private WebElement deliveryFirstName;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > " +
            "div.form-input-group.last-name-group > input")
    private WebElement deliveryLastName;

    @FindBy(css = "#checkout-delivery-options > div > div.u-dir-col.container-b.delivery-methods-address-standard > " +
            "div > div > div.form-input-group.phone-group > input")
    private WebElement deliveryPhoneNumber;

    @FindBy(xpath = "(//div[@class='css-dvua67-singleValue delivery-options__single-value'])[2]")
    private WebElement deliveryCity;


    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div.form-input-group.delivery-address-group > input")
    private WebElement deliveryAdress;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div.delivery-methods-buttons-" +
            "group.u-d-flex.u-d-justify-content-end > span > button.Standard-Button.delivery-address-edit.rsp-delivery-address-edit")
    private WebElement editAdress;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div.group-buttons-actions." +
            "u-w-100.u-text-right > button.Standard-Button.red.delivery-address-save.rsp-delivery-address-save.mr-0")
    private WebElement saveAdress;




    public CheckoutPage assertCheckoutPage() {
        SeleniumUtils.waitForElementToBeVisible(5, deliveryOptionsText);
        Assert.assertEquals(deliveryOptionsText.getText(), deliveryOptionsExpectedText);

        return new CheckoutPage(driver);
    }

    public CheckoutPage selectRandomDeliveryOptions() {
        SeleniumUtils.staticWait(2);
        int randomNumber = RandomNumberGenerator.generateNumber(1, deliveryOptions.size() - 1);
        SeleniumUtils.waitForElementAndClick(5, deliveryOptions.get(randomNumber));

        return new CheckoutPage(driver);
    }

    private CheckoutPage fillNormalDeliveryInfo() {
        JsonObject deliveryData = JsonUtil.getJson("src\\main\\resources\\deliveryDetails.json");
        SeleniumUtils.waitForElementAndClick(5, editAdress);
        SeleniumUtils.staticWait(1);

        deliveryFirstName.clear();
        deliveryFirstName.sendKeys(JsonUtil.getJsonStringElement(deliveryData, "firstName"));

        deliveryLastName.clear();
        deliveryLastName.sendKeys(JsonUtil.getJsonStringElement(deliveryData, "lastName"));

        SeleniumUtils.waitForElementAndClick(5, deliveryPhoneNumber);

        deliveryPhoneNumber.clear();
        deliveryPhoneNumber.sendKeys(JsonUtil.getJsonStringElement(deliveryData, "phoneNumber"));

        SeleniumUtils.clickWriteAndEnter(driver, deliveryCity, JsonUtil.getJsonStringElement(deliveryData, "city"));

        deliveryAdress.clear();
        deliveryAdress.sendKeys(JsonUtil.getJsonStringElement(deliveryData, "adress"));

        saveAdress.click();

        return new CheckoutPage(driver);
    }

    public CheckoutPage fillDeliveryInfo() {
        try {
            fillNormalDeliveryInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

         return new CheckoutPage(driver);
    }


}
