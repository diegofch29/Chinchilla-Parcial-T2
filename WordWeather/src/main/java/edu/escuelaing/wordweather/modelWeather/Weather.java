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
public class Weather {
    public Long id;
    public String main;
    public String description;
    public String  base;

    public Weather(Long id, String main, String description) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.base = base;
    }
    
    
}
