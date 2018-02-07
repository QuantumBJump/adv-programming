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

        int responseCode = connection.getResponseCode();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        System.out.println(response);

        String stringResponse = response.toString();
        JsonParser parser = new JsonParser();
        JsonObject weather = parser.parse(stringResponse).getAsJsonObject().getAsJsonArray("weather").get(0).getAsJsonObject();
        JsonObject main = parser.parse(stringResponse).getAsJsonObject().get("main").getAsJsonObject();
        String currentTemp = main.get("temp").getAsString() + "C\n";
        String minTemp = "min: " + main.get("temp_min").getAsString() + "C, ";
        String maxTemp = "max: " + main.get("temp_max").getAsString() + "C";
        System.out.println(main);
        String mainWeather = weather.get("main").getAsString() + ", ";

        String location = "weather in London: ";
//        String mainWeather = jobj.get("weather").;
//        String temp = jobj.get("temp").getAsString() + "degrees C";

        String weatherString = location + mainWeather + currentTemp + minTemp + maxTemp;

        System.out.println(weatherString);

        in.close();
        return weatherString;

    }
}
