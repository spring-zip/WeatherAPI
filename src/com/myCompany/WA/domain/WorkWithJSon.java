package com.myCompany.WA.domain;

public class WorkWithJSon {

    public static String parseJson(String str) {

        if (!str.isEmpty()) {

            org.json.JSONObject obj = new org.json.JSONObject(str);

            double tempInfo = obj.getJSONObject("main").getDouble("temp");
            double tempFeels = obj.getJSONObject("main").getDouble("feels_like");
            int humidity = obj.getJSONObject("main").getInt("humidity");
            int pressure = obj.getJSONObject("main").getInt("pressure");
            int wind =  obj.getJSONObject("wind").getInt("speed");

            return "Температура: " + tempInfo + "°C" + "; Ощущается как: " + tempFeels + "°C" + "\nВлажность: " + humidity + "%"
                    + "\nДавление: " + pressure + " мм рт. ст." + "\nСкорость ветра: " + wind + " м/с";
        }
        return str;
    }
}
