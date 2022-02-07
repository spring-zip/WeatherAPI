package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.NoNetworkException;

public class CheckCitiesRepository {

    WeatherService service = new WeatherService(); /// нужно т.к. API погоды работает и с латинскими буквами

    public boolean isListEmpty(CitiesRepository listCities) {
        return listCities.getListCities().size() == 0;
    }


    public boolean isNoCityInList (String cityName, CitiesRepository listCities) throws NoNetworkException {

        cityName = service.createCity(cityName).getCityName(); /// нужно т.к. API погоды работает и с латинскими буквами

        for (int i = 0; i < listCities.getListCities().size(); i++) {
            City city = listCities.getListCities().get(i);
            if (city.getCityName().equals(cityName)) {
                return false;
            }
        }
        return true;
    }

}
