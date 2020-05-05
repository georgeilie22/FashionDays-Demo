package core.utils;

import com.google.gson.JsonObject;

public class FormatUtil {

    public static String convertJsonValueToString(JsonObject jsonObject, String key){

        return jsonObject.get(key).getAsString();
    }
}
