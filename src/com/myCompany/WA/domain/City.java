package com.myCompany.WA.domain;

public class City {

    private String city;
    private String country;
    private double tempInfo;
    private double tempFeels;
    private int humidity;
    private int pressure;
    private int wind;

    public City(GetParseJson jsonCity) {
        this.setWeather(jsonCity);
    }

    private void setWeather(GetParseJson jsonCity) {

            city = jsonCity.city;
            country = jsonCity.country;
            tempInfo = jsonCity.tempInfo;
            tempFeels = jsonCity.tempFeels;
            humidity = jsonCity.humidity;
            pressure = jsonCity.pressure;
            wind =  jsonCity.wind;
    }

    public String getCityName(){
        return city;
    }
    public String getCountryName(){
        return country;
    }
    public double getTempInfo(){
        return tempInfo;
    }
    public double getTempFeels(){
        return tempFeels;
    }
    public int getHumidity(){
        return humidity;
    }
    public int getPressure(){
        return pressure;
    }
    public int getWind(){
        return wind;
    }
}
