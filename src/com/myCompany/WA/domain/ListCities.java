package com.myCompany.WA.domain;

import java.util.ArrayList;
import java.util.Comparator;

public class ListCities {


    ArrayList <City> cities = new ArrayList<>();

    public void setListCities(City city) {
        cities.add(city);
        Comparator<City> comparator = Comparator.comparing(City::getCityName);
        cities.sort(comparator);
    }

    public String getListCities() {
        String listCities = "";
        int i;
        for (i=0; i < cities.size(); i++) {
            listCities += (i + 1) + ". " + cities.get(i).getCityCountry() + "\n";
        }
        return listCities;
    }

    public String getCityWeather (int numberCity) {
        return cities.get(numberCity - 1).getWeather();
    }

    public ArrayList getCities(){
        return cities;
    }
}
