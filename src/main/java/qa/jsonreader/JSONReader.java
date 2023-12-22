package qa.jsonreader;

import com.google.common.io.Resources;
import org.json.JSONArray;
import org.json.JSONObject;
import qa.data.Link;
import qa.data.Phrase;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.IntStream;


public class JSONReader {

    private static JSONObject jsonObject;

    private static JSONArray getJSONArray(String key, String node) {

        Object object = jsonObject.get(key);
        JSONObject jsonObject1 = (JSONObject) object;

        return jsonObject1.getJSONArray(node);
    }

    public static void read() throws IOException {

        URL url = Resources.getResource("data.json");

        jsonObject = new JSONObject(Resources.toString(url, StandardCharsets.UTF_8));
    }

    public static Phrase[] getPhrases(String node) {

        JSONArray jsonArray = getJSONArray("searchEngine", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Phrase(
                        jsonArray.getJSONObject(i).getString("phrase"),
                        jsonArray.getJSONObject(i).getString("message")
                ))
                .toArray(Phrase[]::new);
    }

    public static Link[] getLinks(String node) {

        JSONArray jsonArray = getJSONArray("links", node);

        return IntStream.range(0, jsonArray.length())
                .mapToObj(i -> new Link(
                        jsonArray.getJSONObject(i).getString("data"),
                        jsonArray.getJSONObject(i).getString("url")
                ))
                .toArray(Link[]::new);
    }
}
