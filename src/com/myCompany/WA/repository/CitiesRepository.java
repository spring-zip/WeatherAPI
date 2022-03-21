package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.WeatherProgramException;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class CitiesRepository {

    private WeatherService service = new WeatherService();
    private List<City> listCities = new ArrayList<>();

    private void addCity(City newCity) {
        listCities.add(newCity);
    }

    public List<City> getListCities() {
        Comparator<City> comparator = Comparator.comparing(City::getCityName);
        listCities.sort(comparator);
        return listCities;
    }

    public City getCityByIndex(int index) throws WeatherProgramException {
        try {
            return listCities.get(index);
        } catch (NullPointerException e) {
            throw new WeatherProgramException("Список истории запросов пуст.");
        } catch (IndexOutOfBoundsException e) {
            throw new WeatherProgramException("Введён не верный индекс города. В истории запросов такого города нет.");
        }
    }

    public City getCityByName(String cityName) throws WeatherProgramException {
        try {
            return getCityInLocalBase(cityName);
        } catch (WeatherProgramException e) {
            City newCity = service.getCity(cityName);
            addCity(newCity);
            return newCity;
        }
    }

    private City getCityInLocalBase(String cityName) throws WeatherProgramException {
        for (City city : listCities) {
            if (city.getCityName().equals(cityName)) {
                return city;
            }
        }
        throw new WeatherProgramException("Город в локальной базе данных не найден");
    }
}
