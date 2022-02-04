package com.myCompany.WA.view;

import com.myCompany.WA.repository.CheckCitiesRepository;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.domain.City;


public class ClientCenterView {
    CheckCitiesRepository check = new CheckCitiesRepository();

    public void start (){
        System.out.println("Для выхода введите finish.\n" +
                "Для вывода истории запросов городов введите list. \n" +
                "Введите название города: ");
    }

    public void showCityWeather(City city) {
        System.out.println("Город: " + city.getCityName() +
                ". Код страны: " + city.getCountryName() +
                "\nТемпература: " + city.getTempInfo() + "°C" +
                "; Ощущается как: " + city.getTempFeels() + "°C" +
                "\nВлажность: " + city.getHumidity() + "%" +
                "\nДавление: " + city.getPressure() + " мм рт. ст." +
                "\nСкорость ветра: " + city.getWind() + " м/с\n");
    }

    public void showCityInfo(int index, CitiesRepository listCities) {
        if (index < 0) {
            switch (index) {
                case -1:
                    System.out.println("Ошибка: ответ сервера не в поном объеме или содержит ошибку\n");
                    break;
                case -2:
                    System.out.println("Такой город не был найден!\n");
                    break;
                case -3:
                    System.out.println("Нет подключения к интернету!\n");
                    break;
            }
        } else {
        showCityWeather(listCities.getCityByIndex(index));
        }
    }

    public void showHistoryRequestCities(CitiesRepository listCities) {
        if (check.isListEmpty(listCities)){
            System.out.println("Список истории запросов пуст.\n");
        } else {
            String citiesList = "";
            int i;
            for (i = 0; i < listCities.getListCities().size(); i++) {
                City city = listCities.getListCities().get(i);
                citiesList += (i+1) + ". " + "Город: " + city.getCityName() + ". Код страны: " + city.getCountryName() + "\n";
            }
            System.out.println(citiesList);
        }
    }


    public void showCityInfoByHistoryNumber(int index, CitiesRepository listCities) {
        if (check.isListEmpty(listCities)) {
            System.out.println("Список истории запросов пуст.\n");
        } else if (check.isIndexOutOfBounds(index, listCities)) {
            System.out.println("Введён не верный индекс города. В истории запроса такого города нет.\n");
        } else {
            showCityWeather(listCities.getCityByIndex(index));
        }
    }
}
