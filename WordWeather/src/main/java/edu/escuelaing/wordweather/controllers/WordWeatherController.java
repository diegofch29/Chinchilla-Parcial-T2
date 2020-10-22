/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.wordweather.controllers;

import edu.escuelaing.wordweather.Services.OpenWeatherService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author diego
 */


//4f445b4c6e4947e5a638b7b4542bd46a
@RestController
@RequestMapping(value = "/WordW")
public class WordWeatherController {
    
    @Autowired
    private OpenWeatherService serviceWeather;
    
    @GetMapping("/{city}")
    public ResponseEntity<?> getAllData(@PathVariable String city){
        try{
            System.out.println("Looking......");
            System.out.println(city);
            System.out.println("Finished looking");
            return new ResponseEntity<>(serviceWeather.getCityWeather(city) ,HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity<>("Looks like something broke again", HttpStatus.BAD_REQUEST);
        }
    }
}
