package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BaseObject {
    WebDriver driver;

   public BaseObject(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
