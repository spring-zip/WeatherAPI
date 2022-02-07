package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;
import com.myCompany.WA.domain.NoNetworkException;

import java.util.ArrayList;
import java.util.Comparator;

public class CitiesRepository {

    private ArrayList<City> listCities = new ArrayList<>();

    public void addCity(City city) {
            listCities.add(city);
            Comparator<City> comparator = Comparator.comparing(City::getCityName);
            listCities.sort(comparator);
    }

    public ArrayList<City> getListCities() {
        return listCities;
    }

    public City getCityByIndex(int index) throws NoNetworkException {
        try {
            return listCities.get(index);
        } catch (NullPointerException e) {
            throw new NoNetworkException("Список истории запросов пуст.");
        } catch (IndexOutOfBoundsException e) {
            throw new NoNetworkException("Введён не верный индекс города. В истории запросов такого города нет.");
        }
    }
}
