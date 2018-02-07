package zoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.*;

/**
 * Created by quinns on 07/02/18.
 */
public class WeatherReporter{
    public String getWeather() throws Exception {
        String APIKEY = "bf14faae6678e07322cdfb64dbfc8c13";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London&units=metric&APPID=" + APIKEY;

        URL obj = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        // get a json response from the API
        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }

        // convert it into a string so it can be used with gson
        String stringResponse = response.toString();
        JsonParser parser = new JsonParser();
        // cut up the json object so we only need to look through the bits we want to.
        JsonObject weather = parser.parse(stringResponse).getAsJsonObject().getAsJsonArray("weather").get(0).getAsJsonObject();
        JsonObject main = parser.parse(stringResponse).getAsJsonObject().get("main").getAsJsonObject();

        // Generate some strings with information about the weather which we will later...
        String currentTemp = main.get("temp").getAsString() + "C\n";
        String minTemp = "min: " + main.get("temp_min").getAsString() + "C, ";
        String maxTemp = "max: " + main.get("temp_max").getAsString() + "C";
        String mainWeather = weather.get("main").getAsString() + ", ";
        String location = "weather in London: ";
        // ...splice together to form the label text.
        String weatherString = location + mainWeather + currentTemp + minTemp + maxTemp;

        // clean up after ourselves.
        in.close();
        // return the spliced-together string to put on the page.
        return weatherString;

    }
}
