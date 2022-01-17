package com.myCompany.WA.domain;

public class Cities {

    private String city;
    private String country;
    private Double tempInfo;
    private Double tempFeels;
    private int humidity;
    private int pressure;
    private int wind;

    public Cities(String cityName) {
        setWeather(cityName);
    }

    private void setWeather(String cityName) {

            String jsonCity = new UrlContent().getUrlContent(cityName);
            org.json.JSONObject obj = new org.json.JSONObject(jsonCity);

            city = obj.getString("name");
            country = obj.getJSONObject("sys").getString("country");
            tempInfo = obj.getJSONObject("main").getDouble("temp");
            tempFeels = obj.getJSONObject("main").getDouble("feels_like");
            humidity = obj.getJSONObject("main").getInt("humidity");
            pressure = obj.getJSONObject("main").getInt("pressure");
            wind =  obj.getJSONObject("wind").getInt("speed");
    }

    public String getWeather(String cityName) {

        return "Город: " + city + ". Код страны: " + country + "\nТемпература: " + tempInfo + "°C"
            + "; Ощущается как: " + tempFeels + "°C" + "\nВлажность: " + humidity
            + "%" + "\nДавление: " + pressure + " мм рт. ст." + "\nСкорость ветра: " + wind + " м/с";
    }
}
