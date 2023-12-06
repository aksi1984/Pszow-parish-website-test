package qa.jsonreader;

import com.google.common.io.Resources;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;


public class JSONReader {

    private static JSONObject jsonObject;

    public static void read() throws IOException {

        URL url = Resources.getResource("data.json");

        jsonObject = new JSONObject(Resources.toString(url, StandardCharsets.UTF_8));
    }

    public static String[] get(String key, String node) {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;
        JSONArray jsonArray = jsonObject1.getJSONArray(node);

        String[] data = new String[jsonArray.length()];

        for (int i = 0; i < jsonArray.length(); i++) {

            data[i] = jsonArray.getString(i);
        }

        return data;
    }
}