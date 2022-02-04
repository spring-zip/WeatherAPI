package com.myCompany.WA.controller;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.repository.CheckCitiesRepository;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.repository.WeatherService;

import java.util.Scanner;

public class Controller {

    WeatherService service = new WeatherService();
    CheckCitiesRepository check = new CheckCitiesRepository();
    Scanner input = new Scanner(System.in);

    public Scanner inputData(){
        return input;
    }


    public int getIndexCityByName(String cityName, CitiesRepository listCities) {
        int index = 0;

        if (check.isNoCityInList(cityName, listCities)) {
            switch (service.parseJson(cityName)) {
                case WeatherService.DISCONNECT:
                    index = -3;
                    return index;
                case WeatherService.NO_CITY:
                    index = -2;
                    return index;
                case WeatherService.REQUEST_ERROR:
                    index = -1;
                    return index;
                case WeatherService.INFORMATION_RECEIVED:
                    City newCity = new City(service.city, service.country,
                            service.tempInfo, service.tempFeels, service.humidity,
                            service.pressure, service.wind);
                    listCities.addCity(newCity);

                    /*newCity.getCityName() Сделано дополнительно, т.к. API погоды
                      возвращает JSON и для городов написанных латинецей*/
                    index = getIndexInLocalBase(newCity.getCityName(), listCities);
                    break;
            }
        } else {
            index = getIndexInLocalBase(cityName, listCities);
        }
        return index;

    }

    int getIndexInLocalBase(String cityName, CitiesRepository listCities) {
        int index = 0;
        for (int i = 0; i < listCities.getListCities().size(); i++) {
            City city = listCities.getListCities().get(i);
            if (city.getCityName().equals(cityName)) {
                index = i;
                break;
            }
        }
        return index;
    }
}