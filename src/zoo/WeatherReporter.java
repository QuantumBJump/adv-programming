package zoo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by quinns on 07/02/18.
 */
public class WeatherReporter{
    public void getWeather() throws Exception {
        String APIKEY = "bf14faae6678e07322cdfb64dbfc8c13";
        String url = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=" + APIKEY;

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
        in.close();
        System.out.println(response);
    }
}
