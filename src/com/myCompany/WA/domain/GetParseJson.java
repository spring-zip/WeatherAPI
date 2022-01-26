package com.myCompany.WA.domain;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

 public class GetParseJson {

     String city;
     String country;
     Double tempInfo;
     Double tempFeels;
     int humidity;
     int pressure;
     int wind;

     public boolean isJsonObjectCorrect (String cityName){
         try {
             String urlContent = this.getUrlContent(cityName);
             org.json.JSONObject obj = new org.json.JSONObject(urlContent);

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

    public String getUrlContent(String cityName) {
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
           return "Такой город не был найден!";
        }
        return content.toString();
    }

    public String exception (String cityName) {
         if (this.getUrlContent(cityName).equals("Такой город не был найден!")) {
             return "Такой город не был найден!\n";
         } else if (!this.isJsonObjectCorrect(cityName)) {
             return "Ошибка: ответ сервера не в поном объеме или содержит ошибку\n";
         }
        return "Неизвестное исключение";
    }
}
