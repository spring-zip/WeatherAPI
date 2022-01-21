package com.myCompany.WA.domain;

import org.json.JSONException;

public class ParseJson {

    String city;
    String country;
    Double tempInfo;
    Double tempFeels;
    int humidity;
    int pressure;
    int wind;

    public boolean isJsonObjectCorrect (String cityName){
        try {
            String jsonCity = new UrlContent().getUrlContent(cityName);
            org.json.JSONObject obj = new org.json.JSONObject(jsonCity);

            city = obj.getString("name");
            country = obj.getJSONObject("sys").getString("country");
            tempInfo = obj.getJSONObject("main").getDouble("temp");
            tempFeels = obj.getJSONObject("main").getDouble("feels_like");
            humidity = obj.getJSONObject("main").getInt("humidity");
            pressure = obj.getJSONObject("main").getInt("pressure");
            wind =  obj.getJSONObject("wind").getInt("speed");

        } catch (JSONException e) {
            return false;
        }
        return true;
    }
}

