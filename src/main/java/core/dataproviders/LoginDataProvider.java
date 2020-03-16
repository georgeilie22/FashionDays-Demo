package core.dataproviders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import core.utils.JsonUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "invalidlogin")
    public Object[][] dataProviderMethod() {
        JsonObject emails = JsonUtil.getJson("src\\main\\resources\\emails.json");
        JsonArray emailArray = emails.getAsJsonArray("invalid_email_values");
        JsonObject passwords = JsonUtil.getJson("src\\main\\resources\\passwords.json");
        JsonArray passwrodsArray = passwords.getAsJsonArray("invalid_password_values");

        Object[][] obiect = new Object[17][2];
        for (int nr = 0; nr < emailArray.size(); nr++) {
            obiect[nr][0] = emailArray.get(nr).toString().replace("\"", "");
            obiect[nr][1] = passwrodsArray.get(nr).toString().replace("\"", "");
        }

        return obiect;
    }
}
