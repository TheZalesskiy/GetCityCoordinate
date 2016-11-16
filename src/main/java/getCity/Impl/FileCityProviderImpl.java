package getCity.Impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**Service read from file */
public  class FileCityProviderImpl implements CityProvider {

    @Override
    public List<String> getCityList(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;
        List<String> lines = new ArrayList<String>();
        while ((line = reader.readLine()) != null) {
            lines.add(line);
            for (String s : lines) {
            }

        }
        return lines;
    }
}