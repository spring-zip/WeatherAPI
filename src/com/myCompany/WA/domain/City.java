package com.myCompany.WA.domain;

public class City {

    private String city;
    private String country;
    private Double tempInfo;
    private Double tempFeels;
    private int humidity;
    private int pressure;
    private int wind;

    public City(ParseJson jsonCity) {
        setWeather(jsonCity);
    }

    private void setWeather(ParseJson jsonCity) {

            city = jsonCity.city;
            country = jsonCity.country;
            tempInfo = jsonCity.tempInfo;
            tempFeels = jsonCity.tempFeels;
            humidity = jsonCity.humidity;
            pressure = jsonCity.pressure;
            wind =  jsonCity.wind;
    }

    public String getWeather() {
        return toString();
    }

    @Override
    public String toString() {
        return "Город: " + city +
                ". Код страны: " + country +
                "\nТемпература: " + tempInfo + "°C" +
                "; Ощущается как: " + tempFeels + "°C" +
                "\nВлажность: " + humidity + "%" +
                "\nДавление: " + pressure + " мм рт. ст." +
                "\nСкорость ветра: " + wind + " м/с\n";
    }

    public String getCityCountry(){
        return "Город: " + city +
               ". Код страны: " + country;
    }

    public String getCityName(){
        return city;
    }
}
