package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;

public class CheckCitiesRepository {

    public boolean isNoCityInList (String cityName, CitiesRepository listCities) {

        for (int i = 0; i < listCities.getListCities().size(); i++) {
            City city = listCities.getListCities().get(i);
            if (city.getCityName().equals(cityName)) {
                return false;
            }
        }
        return true;
    }

}
