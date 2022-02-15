package com.myCompany.WA.controller;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CheckCitiesRepository;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.repository.WeatherService;

import java.util.Scanner;

public class Controller {

    WeatherService service = new WeatherService();
    CheckCitiesRepository check = new CheckCitiesRepository();
    Scanner input = new Scanner(System.in);

    public Scanner inputData() {
        return input;
    }

    public City getCityByName(String cityName, CitiesRepository listCities) throws WeatherProgramException {
            if (check.isNoCityInList(cityName, listCities)) {
                listCities.addCity(service.getCityFromRemoteRepository(cityName));
            }
            int index;
            index = getIndexInLocalBase(cityName, listCities);
            return listCities.getCityByIndex(index);
    }

    private int getIndexInLocalBase (String cityName, CitiesRepository listCities) throws IndexOutOfBoundsException {
        int index = -1;
        for (int i = 0; i < listCities.getListCities().size(); i++) {
            City city = listCities.getListCities().get(i);
            if (city.getCityName().equals(cityName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public City getCityByIndex(int index, CitiesRepository listCities) throws WeatherProgramException {
        return listCities.getCityByIndex(index);
    }
}