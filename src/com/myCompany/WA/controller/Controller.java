package com.myCompany.WA.controller;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CitiesRepository;

import java.util.Scanner;

public class Controller {

    CitiesRepository listCities = new CitiesRepository();
    Scanner input = new Scanner(System.in);

    public Scanner inputData() {
        return input;
    }

    public City getCityByIndex(int index) throws WeatherProgramException {
        return listCities.getCityByIndex(index);
    }

    public City getCityByName(String cityName) throws WeatherProgramException {
        return listCities.getCityByName(cityName);
    }

    public String getHistoryRequestCities() {
        if (listCities.getListCities().size() == 0) {
            return "Список истории запросов пуст.";
        } else {
            StringBuilder requestHistory = new StringBuilder();

            for (int i = 0; i < listCities.getListCities().size(); i++) {
                City city = listCities.getListCities().get(i);
                requestHistory.append(i + 1).append(". ").append("Город: ").append(city.getCityName()).
                        append(". Код страны: ").append(city.getCountryName()).append("\n");
            }
            return String.valueOf(requestHistory);
        }
    }
}