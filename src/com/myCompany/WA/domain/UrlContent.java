package com.myCompany.WA.domain;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

 public class UrlContent {

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
            return "Такой город не был найден!\n";
        }
        return content.toString();
    }
}
