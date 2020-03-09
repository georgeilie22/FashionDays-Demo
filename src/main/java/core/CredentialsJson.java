package core;

import com.google.gson.JsonObject;
import core.utils.JsonUtil;

/**
 * This class is used to get a credential form a json.
 */
public class CredentialsJson {

    private static final String PATH = "src\\main\\resources\\credentials.json";

    /**
     * This method converts a json object to a string after taking the specified value;
     *
     * @param credentialKey is the key to the value desired {"username": "george"} where username is the key and george is the value;
     * @return the specified value converted from the json file;
     */
    public static String getCredential(String credentialKey) {
        JsonObject credentialsJson = JsonUtil.getJson(PATH);
        return credentialsJson.get(credentialKey).toString().replace("\"", "");
    }
}
