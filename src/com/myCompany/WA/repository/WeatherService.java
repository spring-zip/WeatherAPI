package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.ConnectionAvailability;
import com.myCompany.WA.domain.WeatherProgramException;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.net.URL;
import java.net.URLConnection;

public class WeatherService {

    private ConnectionAvailability netWork = new ConnectionAvailability();

    private String getUrlContent(String cityName) throws WeatherProgramException {
        if (netWork.isNetworkReachable()) {
            try {
                StringBuilder content = new StringBuilder();

                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                        + cityName + "&appid=ce1d4b74bf00f8e5d52226428613c523&units=metric&lang=ru");
                URLConnection urlConn = url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
                    return content.toString();

            } catch (IOException e){
                throw new WeatherProgramException("Такой город не был найден!");
            }
        } else {
            throw new WeatherProgramException("Нет подключения к интернету!");
        }
    }

    private City convertJsonToCity(String json) throws WeatherProgramException {

        City newCity;
        org.json.JSONObject obj = new org.json.JSONObject(json);
        try {
            newCity = new City(obj.getString("name"),
                    obj.getJSONObject("sys").getString("country"),
                    obj.getJSONObject("main").getDouble("temp"),
                    obj.getJSONObject("main").getDouble("feels_like"),
                    obj.getJSONObject("main").getInt("humidity"),
                    obj.getJSONObject("main").getInt("pressure"),
                    obj.getJSONObject("wind").getInt("speed"));

            return newCity;
        } catch (JSONException e){
            throw new WeatherProgramException("Ошибка: ответ сервера не в поном объеме или содержит ошибку");
        }
    }

    public City getCity(String cityName) throws WeatherProgramException {
            return convertJsonToCity(getUrlContent(cityName));
    }
}
