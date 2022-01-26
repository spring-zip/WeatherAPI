package com.myCompany.WA.domain;

public class CheckListCities {

    public boolean isListEmpty(ListCities cities) {
        return cities.getListCities().size() == 0;
    }

    public boolean isIndexOutOfBounds(int index, ListCities cities) {
        return index < 1 || index > cities.getListCities().size();
    }

    public boolean isNoCityInList (City city,ListCities cities) {
        for (int i = 0; i < cities.getListCities().size(); i++) {
            City name = cities.getListCities().get(i);
            if (name.getCityName().equals(city.getCityName())) {
                return false;
            }
        }
        return true;
    }
}
