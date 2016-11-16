package getCity.Impl;

import getCity.JsonReader;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

/**Service get google coordinate for city */
public  class GoogleCoordinatesProviderImpl implements CoordinatesProvider {
    public final String URL_BASE = "https://maps.googleapis.com/maps/api/geocode/json?sensor=false&address=";

    @Override
    public String getCoordinates(String city) throws JSONException, IOException {
        String url = URL_BASE + city ;
        System.out.print(city + " ");
        JSONObject response = JsonReader.read(url);

        JSONObject location = response.getJSONArray("results").getJSONObject(0);
        location = location.getJSONObject("geometry");
        location = location.getJSONObject("location");
        // longitude
        double lng = location.getDouble("lng");
        // latitude
        double lat = location.getDouble("lat");
        // final latitude and longitude
        System.out.println(String.format("%s", location));

        return city;
    }

}
