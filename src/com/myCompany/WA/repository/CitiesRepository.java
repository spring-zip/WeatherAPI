package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.WeatherProgramException;

import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class CitiesRepository {

    private WeatherService service = new WeatherService();
    private List<City> listCities = new ArrayList<>();

    public void addCity(String cityName) throws WeatherProgramException {
        listCities.add(service.getCityFromRemoteRepository(cityName));
        Comparator<City> comparator = Comparator.comparing(City::getCityName);
        listCities.sort(comparator);
    }

    public ArrayList<City> getListCities() {
        return (ArrayList<City>) listCities;
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
        if (isNoCityInList(cityName)) {
            addCity(cityName);
        }
        int index;
        index = getIndexInLocalBase(cityName);
        return getCityByIndex(index);
    }

    private int getIndexInLocalBase (String cityName) throws IndexOutOfBoundsException {
        int index = -1;
        for (int i = 0; i < listCities.size(); i++) {
            City city = listCities.get(i);
            if (city.getCityName().equals(cityName)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean isNoCityInList (String cityName) {

        for (City city : listCities) {
            if (city.getCityName().equals(cityName)) {
                return false;
            }
        }
        return true;
    }
}
