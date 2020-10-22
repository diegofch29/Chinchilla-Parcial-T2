/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.wordweather.modelWeather;

/**
 *
 * @author diego
 */
public class City {
    public Coordinates coord;
    public Weather weather;
    public MainW main;
    public String name;

    public City(Coordinates coord, Weather weather, MainW main, String name) {
        this.coord = coord;
        this.weather = weather;
        this.main = main;
        this.name = name;
    }
    
    
}
