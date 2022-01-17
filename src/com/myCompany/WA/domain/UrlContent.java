package com.myCompany.WA.domain;

import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

 public class UrlContent {

    public String getUrlContent(String cityName) {
        StringBuffer content = new StringBuffer();

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
            return "Такой город не был найден!";
        }
        return content.toString();
    }

     public boolean isJsonObjectCorrect (String cityName){
         try {
             String jsonCity = new UrlContent().getUrlContent(cityName);
             org.json.JSONObject obj = new org.json.JSONObject(jsonCity);

             String city = obj.getString("name");
             String country = obj.getJSONObject("sys").getString("country");
             Double tempInfo = obj.getJSONObject("main").getDouble("temp");
             Double tempFeels = obj.getJSONObject("main").getDouble("feels_like");
             int humidity = obj.getJSONObject("main").getInt("humidity");
             int pressure = obj.getJSONObject("main").getInt("pressure");
             int wind =  obj.getJSONObject("wind").getInt("speed");

         } catch (JSONException e) {
             return false;
         }
         return true;
     }
}
