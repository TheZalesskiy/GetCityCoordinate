package getCity;

import getCity.Impl.CityProvider;
import getCity.Impl.CoordinatesProvider;
import getCity.Impl.FileCityProviderImpl;
import getCity.Impl.GoogleCoordinatesProviderImpl;
import org.json.JSONException;

import java.io.IOException;
import java.util.List;


public class Main {

    public static void main(String[] args) throws IOException, JSONException {
        CityProvider cityProvider = new FileCityProviderImpl();
        CoordinatesProvider coordinatesProvider = new GoogleCoordinatesProviderImpl();

        // fetch city_list list from file
        List<String> cityList = cityProvider.getCityList("src/main/resources/city_list");

        // get coordinate for every city_list
        for (String city : cityList) {
            String coordinates = coordinatesProvider.getCoordinates(city);
            System.out.println("==========================================");
        }

    }
}

