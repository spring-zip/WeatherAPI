package com.myCompany.WA.view;

import com.myCompany.WA.domain.City;

import java.util.List;

public class WeatherView {

    public void start (){
        System.out.println("\nДля выхода введите finish.\n" +
                "Для вывода истории запросов городов введите list. \n" +
                "Введите название города: ");
    }

    public void showCityWeather(City city) {
        if (city != null) {
            System.out.println("Город: " + city.getCityName() +
                    ". Код страны: " + city.getCountryName() +
                    "\nТемпература: " + city.getTempInfo() + "°C" +
                    "; Ощущается как: " + city.getTempFeels() + "°C" +
                    "\nВлажность: " + city.getHumidity() + "%" +
                    "\nДавление: " + city.getPressure() + " мм рт. ст." +
                    "\nСкорость ветра: " + city.getWind() + " м/с");
        }
    }

    public void showHistoryRequestCities(List<City> listCities) {
        if (listCities.size() == 0) {
            System.out.println("Список истории запросов пуст.");

        } else {
            StringBuilder requestHistory = new StringBuilder();

            for (int i = 0; i < listCities.size(); i++) {
                City city = listCities.get(i);

                requestHistory.append(i + 1).
                                    append(". Город: ").
                                    append(city.getCityName()).
                                    append(". Код страны: ").
                                    append(city.getCountryName()).
                                    append("\n");
            }
            System.out.println(requestHistory);
        }
    }
}
