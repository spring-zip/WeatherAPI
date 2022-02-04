package com.myCompany.WA.repository;

import com.myCompany.WA.domain.City;

import java.util.ArrayList;
import java.util.Comparator;

public class CitiesRepository {

    ArrayList<City> listCities = new ArrayList<>();

    public void addCity(City city) {
            listCities.add(city);
            Comparator<City> comparator = Comparator.comparing(City::getCityName);
            listCities.sort(comparator);
    }

    public ArrayList<City> getListCities() {
        return listCities;
    }
    public City getCityByIndex(int index) {
        return listCities.get(index);
    }
}
