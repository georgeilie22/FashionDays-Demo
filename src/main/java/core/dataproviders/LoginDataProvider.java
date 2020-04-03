package core.dataproviders;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import core.utils.JsonUtil;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {

    @DataProvider(name = "invalidEmails")
    public Object[][] invalidEmails() {
        JsonObject emails = JsonUtil.getJson("src\\main\\resources\\emails.json");
        JsonArray emailArray = emails.getAsJsonArray("invalid_email_values");
        JsonObject passwords = JsonUtil.getJson("src\\main\\resources\\passwords.json");
        JsonArray passwrodsArray = passwords.getAsJsonArray("invalid_password_values");

        Object[][] obiect = new Object[emailArray.size()][2];
        for (int nr = 0; nr < emailArray.size(); nr++) {
            obiect[nr][0] = emailArray.get(nr).toString().replace("\"", "");
            obiect[nr][1] = passwrodsArray.get(nr).toString().replace("\"", "");
        }

        return obiect;
    }

    @DataProvider(name = "validEmails")
    public Object[][] validEmails() {
        JsonObject emails = JsonUtil.getJson("src\\main\\resources\\emails.json");
        JsonArray emailArray = emails.getAsJsonArray("valid_email_values");
        JsonObject passwords = JsonUtil.getJson("src\\main\\resources\\passwords.json");
        JsonArray passwrodsArray = passwords.getAsJsonArray("invalid_password_values");

        Object[][] obiect = new Object[emailArray.size()][2];
        for (int nr = 0; nr < emailArray.size(); nr++) {
            obiect[nr][0] = emailArray.get(nr).toString().replace("\"", "");
            obiect[nr][1] = passwrodsArray.get(nr).toString().replace("\"", "");
        }

        return obiect;
    }

    @DataProvider(name = "emptyEmails")
    public Object[][] emptyEmails() {
        JsonObject emails = JsonUtil.getJson("src\\main\\resources\\emails.json");
        JsonArray emailArray = emails.getAsJsonArray("empty_email_values");
        JsonObject passwords = JsonUtil.getJson("src\\main\\resources\\passwords.json");
        JsonArray passwrodsArray = passwords.getAsJsonArray("invalid_password_values");

        Object[][] obiect = new Object[emailArray.size()][2];
        for (int nr = 0; nr < emailArray.size(); nr++) {
            obiect[nr][0] = emailArray.get(nr).toString().replace("\"", "");
            obiect[nr][1] = passwrodsArray.get(nr).toString().replace("\"", "");
        }

        return obiect;
    }

    @DataProvider(name = "emptyPasswords")
    public Object[][] emptyPasswords() {
        JsonObject emails = JsonUtil.getJson("src\\main\\resources\\emails.json");
        JsonArray emailArray = emails.getAsJsonArray("valid_email_values");
        JsonObject passwords = JsonUtil.getJson("src\\main\\resources\\passwords.json");
        JsonArray passwrodsArray = passwords.getAsJsonArray("empty_passwords");

        Object[][] obiect = new Object[passwrodsArray.size()][2];
        for (int nr = 0; nr < passwrodsArray.size(); nr++) {
            obiect[nr][0] = emailArray.get(nr).toString().replace("\"", "");
            obiect[nr][1] = passwrodsArray.get(nr).toString().replace("\"", "");
        }

        return obiect;
    }
}
