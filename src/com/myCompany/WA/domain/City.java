package com.myCompany.WA.domain;

public class City {

    private String city;
    private String country;
    private double tempInfo;
    private double tempFeels;
    private int humidity;
    private int pressure;
    private int wind;

    public City(String city, String country, double tempInfo,
                double tempFeels, int humidity, int pressure, int wind) {
        this.city = city;
        this.country = country;
        this.tempInfo = tempInfo;
        this.tempFeels = tempFeels;
        this.humidity = humidity;
        this.pressure = pressure;
        this.wind =  wind;
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
