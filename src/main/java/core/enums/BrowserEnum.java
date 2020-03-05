package core.enums;

/**
 * These enumerations are used so the user can choose what browser he wants to use;
 * The key and path are used while setting the property for the driver;
 * The user can get the kay and path through getters;
 */
public enum BrowserEnum {

    CHROME("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe"),
    MOZILLA("webdriver.gecko.driver", "src\\main\\resources\\drivers\\geckodriver.exe");


    private String key;
    private String path;

    BrowserEnum(String key, String path) {
        this.key = key;
        this.path = path;
    }

    public String getKey() {
        return key;
    }

    public String getPath() {
        return path;
    }
}


