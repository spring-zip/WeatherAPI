package com.myCompany.WA.domain;

public class CheckListCities {

    public boolean isListEmpty(ListCities cities) {
        return cities.getCities().size() == 0;
    }

    public boolean isIndexOutOfBounds(int index, ListCities cities) {
        return index < 1 || index > cities.getCities().size();
    }

    public boolean isNoCityInList (City city,ListCities cities) {
        for (int i = 0; i < cities.getCities().size(); i++) {
            City name = (City) cities.getCities().get(i);
            if (name.getCityName().equals(city.getCityName())) {
                return false;
            }
        }
        return true;
    }
}
