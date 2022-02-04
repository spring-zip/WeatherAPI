package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;

public class CheckCitiesRepository {

    public boolean isListEmpty(CitiesRepository cities) {
        return cities.getListCities().size() == 0;
    }

    public boolean isIndexOutOfBounds(int index, CitiesRepository cities) {
        return index < 0 || index >= cities.getListCities().size();
    }

    public boolean isNoCityInList (String cityName, CitiesRepository cities) {
        WeatherService service = new WeatherService(); ///Сделано дополнительно, т.к. API погоды возвращает JSON и для городов написанных латинецей
        service.parseJson(cityName); ///Сделано дополнительно, т.к. API погоды возвращает JSON и для городов написанных латинецей
        cityName = service.city; ///Сделано дополнительно, т.к. API погоды возвращает JSON и для городов написанных латинецей

        for (int i = 0; i < cities.getListCities().size(); i++) {
            City city = cities.getListCities().get(i);
            if (city.getCityName().equals(cityName)) {
                return false;
            }
        }
        return true;
    }

}
