package qa.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONReader {

    private static JSONObject jsonObject;

    private static String fileToString(String filepath) {

        try {

            InputStream inputStream = Files.newInputStream(Paths.get(filepath));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line = bufferedReader.readLine();
            StringBuilder stringBuilder = new StringBuilder();

            while (line != null) {

                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }

            return stringBuilder.toString();

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public static void read(String filepath) {

        jsonObject = new JSONObject(fileToString(filepath));
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
