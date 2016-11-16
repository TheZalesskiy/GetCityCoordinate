package getCity.Impl;

import java.io.IOException;
import java.util.List;


public interface CityProvider {
    List<String> getCityList(String path) throws IOException;
}
