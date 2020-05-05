package pageobject;

import com.google.gson.JsonObject;
import core.utils.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CheckoutPage extends Header {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final JsonObject DELIVERY_DATA = JsonUtil.getJson("src\\main\\resources\\deliveryDetails.json");
    private final String FIRST_NAME = FormatUtil.convertJsonValueToString(DELIVERY_DATA, "firstName");
    private final String LAST_NAME = FormatUtil.convertJsonValueToString(DELIVERY_DATA, "lastName");
    private final String PHONE_NUMBER = FormatUtil.convertJsonValueToString(DELIVERY_DATA, "phoneNumber");
    private final String CITY = FormatUtil.convertJsonValueToString(DELIVERY_DATA, "city");
    private final String ADRESS = FormatUtil.convertJsonValueToString(DELIVERY_DATA, "adress");


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

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > " +
            "div.delivery-methods-static-address.easy-box-text-with-map > p.name")
    private WebElement savedDeliveryName;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > " +
            "div.delivery-methods-static-address.easy-box-text-with-map > p.address")
    private WebElement savedDeliveryAdressAndCity;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > " +
            "div.delivery-methods-static-address.easy-box-text-with-map > p.phone")
    private WebElement savedDeliveryPhoneNumber;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div:nth-child(2) > " +
            "div > div.delivery-methods-buttons-group > span > button.Standard-Button.pickup-point-edit.rsp-point-edit > i")
    private WebElement easyBoxEditIcon;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div > " +
            "div.group-buttons-actions.u-w-100.u-text-right > button.Standard-Button." +
            "red.pickup-point-select.rsp-pickup-point-select.mr-0")
    private WebElement easyBoxSelectPickUpPoint;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard " +
            "> div > div > div > div.form-input-group.first-name-group > input")
    private WebElement easyBoxFirstName;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > " +
            "div > div > div > div.form-input-group.last-name-group > input")
    private WebElement easyBoxLastName;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > " +
            "div > div > div > div.form-input-group.phone-group.phone-group-new-adress > input")
    private WebElement easyBoxPhoneNumber;

    @FindBy(css = ".pickup-point-list-item")
    private List<WebElement> deliveryPointsList;

    @FindBy(css = "button[class='Standard-Button red full-width pickup-point-save rsp-pickup-point-save']")
    private WebElement selectDeliveryPointButton;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div:nth-child(2) > " +
            "div > div.pickup-info-all > div.delivery-methods-pickup-point-address > h4")
    private WebElement easyBoxName;

    @FindBy(css = "h4.name")
    private List<WebElement> easyBoxPopUpNamesList;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div:nth-child(2) > " +
            "div > div.pickup-info-all > div.delivery-methods-static-address.easy-box-text-with-map > p.name")
    private WebElement savedEasyBoxDeliveryFullName;

    @FindBy(css = "div.u-dir-col.container-b.delivery-methods-address-standard > div > div > div:nth-child(2) > " +
            "div > div.pickup-info-all > div.delivery-methods-static-address.easy-box-text-with-map > p.phone")
    private WebElement savedEasyBoxDeliveryPhoneNumber;

    @FindBy(css = "div.brand-name")
    private WebElement brandName;

    @FindBy(css = "div.product-name")
    private WebElement productName;

    @FindBy(css = "a[class='remove-from-cart icon-fd-trash']")
    private List<WebElement> trashIconsList;

    @FindBy(css = "a.remove-from-cart.icon-fd-trash")
    private WebElement trashIcon;

    public CheckoutPage assertCheckoutPage() {
        SeleniumUtils.staticWait(1);
        SeleniumUtils.waitForElementToBeVisible(5, deliveryOptionsText);
        String deliveryOptionsExpectedText = "OPTIUNI LIVRARE";
        Assert.assertEquals(deliveryOptionsText.getText(), deliveryOptionsExpectedText);

        return new CheckoutPage(driver);
    }

    public CheckoutPage selectEasyBoxDeliveryOption() {
        SeleniumUtils.staticWait(2);
        SeleniumUtils.waitForElementAndClick(5, deliveryOptions.get(0));

        return new CheckoutPage(driver);
    }

    public CheckoutPage selectStandardDeliveryOptions() {
        SeleniumUtils.staticWait(2);
        SeleniumUtils.waitForElementAndClick(5, deliveryOptions.get(1));

        return new CheckoutPage(driver);
    }

    public CheckoutPage fillNormalDeliveryInfo() {

        SeleniumUtils.waitForElementAndClick(5, editAdress);
        SeleniumUtils.staticWait(1);

        deliveryFirstName.clear();
        deliveryFirstName.sendKeys(FIRST_NAME);

        deliveryLastName.clear();
        deliveryLastName.sendKeys(LAST_NAME);

        SeleniumUtils.waitForElementAndClick(5, deliveryPhoneNumber);

        deliveryPhoneNumber.clear();
        deliveryPhoneNumber.sendKeys(PHONE_NUMBER);

        SeleniumUtils.clickWriteAndEnter(driver, deliveryCity, CITY);

        deliveryAdress.clear();
        deliveryAdress.sendKeys(ADRESS);

        saveAdress.click();

        return new CheckoutPage(driver);
    }

    public CheckoutPage fillEasyboxDeliveryInfo() {

        SeleniumUtils.waitForElementAndClick(5, easyBoxEditIcon);
        SeleniumUtils.staticWait(1);

        easyBoxFirstName.clear();
        easyBoxFirstName.sendKeys(FIRST_NAME);

        easyBoxLastName.clear();
        easyBoxLastName.sendKeys(LAST_NAME);

        easyBoxPhoneNumber.clear();
        easyBoxPhoneNumber.sendKeys(PHONE_NUMBER);

        SeleniumUtils.waitForElementAndClick(5, easyBoxSelectPickUpPoint);

        return new CheckoutPage(driver);
    }

    public String selectRandomPickupPointAndSaveTheName() {
        SeleniumUtils.staticWait(2);
        int randomNumber = RandomNumberGenerator.generateNumber(2, deliveryPointsList.size()) - 1;

        SeleniumUtils.waitForElementAndClick(5, deliveryPointsList.get(randomNumber));
        String name = easyBoxPopUpNamesList.get(randomNumber).getText();

        SeleniumUtils.waitForElementAndClick(5, selectDeliveryPointButton);

        return name;
    }


    public CheckoutPage assertStandardDeliveryInformation() {
        SeleniumUtils.waitForElementToBeVisible(5, savedDeliveryName);
        Assert.assertEquals(savedDeliveryName.getText(), FIRST_NAME + " " + LAST_NAME);

        SeleniumUtils.waitForElementToBeVisible(5, savedDeliveryAdressAndCity);
        Assert.assertEquals(savedDeliveryAdressAndCity.getText(), ADRESS
                + " " + CITY + ", Sectorul 1 (Sectorul 1)");

        SeleniumUtils.waitForElementToBeVisible(5, savedDeliveryPhoneNumber);
        Assert.assertEquals(savedDeliveryPhoneNumber.getText(), "+40" + PHONE_NUMBER);

        return new CheckoutPage(driver);
    }

    public CheckoutPage assertEasyBoxDeliveryInformation(String easyBoxNameSelected) {
        SeleniumUtils.waitForElementToBeVisible(5, easyBoxName);
        Assert.assertEquals(easyBoxName.getText(), easyBoxNameSelected);
        Assert.assertEquals(savedEasyBoxDeliveryFullName.getText(), FIRST_NAME + " " + LAST_NAME);
        Assert.assertEquals(savedEasyBoxDeliveryPhoneNumber.getText(), "+40" + PHONE_NUMBER);

        return new CheckoutPage(driver);
    }

    public CheckoutPage checkIfProductIsMatching(String selectedProduct) {
        SeleniumUtils.staticWait(1);
        Assert.assertEquals(brandName.getText() + "\n" + productName.getText(), selectedProduct);

        return new CheckoutPage(driver);
    }

    public CampainsPage deleteAllProducts(){
        for (int index=0; index<trashIconsList.size();index++){
            SeleniumUtils.waitForElementAndClick(5,trashIconsList.get(index));
        }

        return new CampainsPage(driver);
    }

    public CampainsPage deleteProduct(){
        SeleniumUtils.waitForElementToBeVisible(5,trashIcon);
        JavascriptUtil javascriptUtil= new JavascriptUtil(driver);
        javascriptUtil.click(trashIcon);

        return new CampainsPage(driver);
    }

}

