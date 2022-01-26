package com.myCompany.WA.domain;

import java.util.Scanner;

public class WeatherProgram {

    public void start() {

        Scanner input = new Scanner(System.in);
        ListCities cities = new ListCities();
        ConnectionAvailability checkConnection = new ConnectionAvailability();
        GetParseJson jsonObject = new GetParseJson();
        View view = new View();

        while (true) {
            view.start();

            if (input.hasNextInt()) {
                int listIndex = input.nextInt();
                view.cityInfo(listIndex, cities);

            } else {
                String cityName = input.next();

                if(cityName.equals("finish")){
                    break;
                }

                if (cityName.equals("list")) {
                    view.listCities(cities);
                } else {
                    if (jsonObject.isJsonObjectCorrect(cityName)) {
                        City city = new City(jsonObject);
                        cities.addCity(city);
                        view.cityWeather(city);
                    } else {
                        System.out.println(jsonObject.exception(cityName));
                    }
                }
            }
        }
    }
}

