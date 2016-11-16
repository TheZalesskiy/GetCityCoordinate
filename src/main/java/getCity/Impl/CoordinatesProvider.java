package getCity.Impl;

import org.json.JSONException;
import java.io.IOException;

public interface CoordinatesProvider {
   String getCoordinates(String city) throws JSONException, IOException;
}
