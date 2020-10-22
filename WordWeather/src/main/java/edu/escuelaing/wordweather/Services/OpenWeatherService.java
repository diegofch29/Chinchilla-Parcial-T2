/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.wordweather.Services;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import edu.escuelaing.wordweather.modelWeather.City;
import edu.escuelaing.wordweather.modelWeather.Coordinates;
import edu.escuelaing.wordweather.modelWeather.MainW;
import edu.escuelaing.wordweather.modelWeather.Weather;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 *
 * @author diego
 */

@Service
public class OpenWeatherService {
    
    public City getCityWeather(String cityString){
        HttpResponse<JsonNode> response = null;
        String resp = "no se ha encontrado el pais";
        try {
            response = Unirest
                    .get("http://api.openweathermap.org/data/2.5/weather?q="+cityString+"&appid=4f445b4c6e4947e5a638b7b4542bd46a")
                    .asJson();
        } catch (UnirestException ex) {
            Logger.getLogger(OpenWeatherService.class.getName()).log(Level.SEVERE, null, ex);
        }
        resp = response.getBody().toString();
        return toCity(response);
    }
    
    private City toCity(HttpResponse<JsonNode> data){
        JSONObject cityJson = data.getBody().getObject();
        JSONObject coordJson = cityJson.getJSONObject("coord");
        Coordinates coord = new Coordinates(coordJson.getLong("lon"),coordJson.getLong("lat"));
        JSONObject weatherJson = cityJson.getJSONArray("weather").getJSONObject(0);
        Weather weather = new Weather(weatherJson.getLong("id"), weatherJson.getString("main"),weatherJson.getString("description"));
        JSONObject mainJson = cityJson.getJSONObject("main");
        MainW mainw = new MainW(mainJson.getLong("temp"),mainJson.getLong("feels_like"),mainJson.getLong("temp_min"),mainJson.getLong("temp_max"),mainJson.getLong("pressure"),mainJson.getLong("humidity"));
        
        return new City(coord,weather,mainw,cityJson.getString("name"));
    }
    
    
    
}
