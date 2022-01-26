package com.myCompany.WA.domain;

import java.util.ArrayList;
import java.util.Comparator;

public class ListCities {

    ArrayList<City> listCities = new ArrayList<>();
    CheckListCities check = new CheckListCities();

    public void addCity(City city) {
        if (check.isNoCityInList(city, this)){
            listCities.add(city);
            Comparator<City> comparator = Comparator.comparing(City::getCityName);
            listCities.sort(comparator);
        }
    }

    public ArrayList<City> getListCities() {
        return listCities;
    }


}
