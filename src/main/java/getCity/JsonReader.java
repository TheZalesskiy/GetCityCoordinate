package getCity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * To contact the web services and response in json
 */
public class JsonReader {
    private static String readAll(final Reader rd) throws IOException {
        final StringBuilder stringBuilder = new StringBuilder();
        int i;
        while ((i = rd.read()) != -1) {
            stringBuilder.append((char) i);
        }
        return stringBuilder.toString();
    }

    public static JSONObject read(final String url) throws IOException, JSONException {
        final InputStream inputStream = new URL(url).openStream();
        try {
            final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,
                    Charset.forName("UTF-8")));
            final String jsonText = readAll(reader);
            final JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            inputStream.close();
        }

    }

}
