package net.taobits.katas.hexagonal;

import com.google.common.io.CharStreams;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class ApiAccess {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://apis.is/weather/observations/en?stations=1");
            try (InputStream inputStream = url.openStream();
                 InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8)
            ) {
//                Gson gson = new Gson();
//                gson.fromJson(inputStreamReader, Map.class).getResults();
                JSONTokener tokener = new JSONTokener(inputStreamReader);
                JSONObject jsonObject = new JSONObject(tokener);
                System.out.println(jsonObject.toString(2));
//                System.out.println(CharStreams.toString(inputStreamReader));
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("unable to parse URL", e);
        } catch (IOException e) {
            throw new RuntimeException("unable to readData", e);
        }
    }
}
