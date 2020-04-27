package core.utils;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.FileNotFoundException;
import java.io.FileReader;


/**
 * This class is used to convert a json file to a json java object;
 */
public class JsonUtil {

    /**
     * This method is used to make a json object that contains the data from a json file.
     *
     * @param path of the json file
     * @return the json object with the specific data
     */
    public static JsonObject getJson(String path) {
        Gson gson = new Gson();
        JsonObject jsonObject = null;
        try {
            jsonObject = gson.fromJson(new FileReader(path), JsonObject.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    public static String getJsonStringElement(JsonObject jsonObject, String credential){

        return jsonObject.get(credential).toString().replace("\"", "");
    }
}
