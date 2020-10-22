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
public class MainW {
    public Long temperature;
    public Long fells;
    public Long tempMin;
    public Long tempMax;
    public Long pressure;
    public Long humidity;
    public Long visibility;

    public MainW(Long temperature, Long fells, Long tempMin, Long tempMax, Long pressure, Long humidity) {
        this.temperature = temperature;
        this.fells = fells;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.visibility = visibility;
    }
    
}
