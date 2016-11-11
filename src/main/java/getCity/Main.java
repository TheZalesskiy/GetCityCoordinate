package getCity;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException, JSONException {
        // Path to the Geocoding API over HTTP
        final String baseUrl = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";

        BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/city"));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
            for (String s : lines) {

            }
            // generate a path with parameters
            final String url = baseUrl + line;
            System.out.print(line + " ");

            //service response
            // System.out.println(url);

            // request to the web service and get a reply from him
            final JSONObject response = JsonReader.read(url);

            JSONObject location = response.getJSONArray("results").getJSONObject(0);
            location = location.getJSONObject("geometry");
            location = location.getJSONObject("location");
            // longitude
            final double lng = location.getDouble("lng");
            // latitude
            final double lat = location.getDouble("lat");
            // final latitude and longitude
            System.out.println(String.format("%s", location));
        }
    }
}
