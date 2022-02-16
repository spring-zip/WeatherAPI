package com.myCompany.WA.controller;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CitiesRepository;

import java.util.List;
import java.util.Scanner;

public class Controller {

    CitiesRepository repository = new CitiesRepository();
    Scanner input = new Scanner(System.in);

    public Scanner inputData() {
        return input;
    }

    public City getCityByIndex(int index) {
        try {
            return repository.getCityByIndex(index);
        } catch (WeatherProgramException e) {
            System.out.println(e.getMessage());
        }
        return null;  // in real program don't return NULL !!!
    }

    public City getCityByName(String cityName) {
        try {
            return repository.getCityByName(cityName);
        } catch (WeatherProgramException e) {
            System.out.println(e.getMessage());
        }
        return null;  // in real program don't return NULL !!!
    }

    public List<City> getHistoryRequestCities() {
        return repository.getListCities();
    }
}