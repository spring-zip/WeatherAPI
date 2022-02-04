package com.myCompany.WA.repository;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class WeatherService {

    public String city;
    public String country;
    public Double tempInfo;
    public Double tempFeels;
    public int humidity;
    public int pressure;
    public int wind;

    public static final String DISCONNECT = "Нет подключения к интернету!";
    public static final String NO_CITY = "Такой город не был найден!";
    public static final String REQUEST_ERROR = "Ошибка: ответ сервера не в поном объеме или содержит ошибку";
    public static final String INFORMATION_RECEIVED = "Информация с сервера получена в полном объёме";

    public boolean isNetworkReachable() {
        try {
            URL url = new URL("https://google.com/");

            HttpURLConnection urlConnect = (HttpURLConnection)url.openConnection();

            Object objData = urlConnect.getContent();

        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public String getUrlContent(String cityName) {

        if (isNetworkReachable()) {

            StringBuilder content = new StringBuilder();

            try {
                URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q="
                        + cityName + "&appid=ce1d4b74bf00f8e5d52226428613c523&units=metric&lang=ru");
                URLConnection urlConn = url.openConnection();

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    content.append(line + "\n");
                }
                bufferedReader.close();
            } catch (Exception e) {
                return NO_CITY;
            }
            return content.toString();
        } else {
            return DISCONNECT;
        }

    }

    public String parseJson(String cityName) {

        String urlContent = getUrlContent(cityName);

        if (urlContent.equals(DISCONNECT)){
            return DISCONNECT;
        } else if (urlContent.equals(NO_CITY)) {
            return NO_CITY;
        } else {
            try {
            org.json.JSONObject obj = new org.json.JSONObject(urlContent);

            city = obj.getString("name");
            country = obj.getJSONObject("sys").getString("country");
            tempInfo = obj.getJSONObject("main").getDouble("temp");
            tempFeels = obj.getJSONObject("main").getDouble("feels_like");
            humidity = obj.getJSONObject("main").getInt("humidity");
            pressure = obj.getJSONObject("main").getInt("pressure");
            wind = obj.getJSONObject("wind").getInt("speed");

            } catch (JSONException e) {
                return REQUEST_ERROR;
            }
            return INFORMATION_RECEIVED;
        }
    }
}
