package com.myCompany.WA.view;

import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.domain.City;

public class WeatherView {

    public void start (){
        System.out.println("\nДля выхода введите finish.\n" +
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
                "\nСкорость ветра: " + city.getWind() + " м/с");
    }

    public void showHistoryRequestCities(CitiesRepository listCities) {
        try {
            StringBuilder requestHistory = new StringBuilder();
            int i;
            for (i = 0; i < listCities.getListCities().size(); i++) {
                City city = listCities.getListCities().get(i);
                requestHistory.append(i + 1).append(". ").append("Город: ").append(city.getCityName()).
                        append(". Код страны: ").append(city.getCountryName()).append("\n");
            }
            System.out.println(requestHistory);
        } catch (NullPointerException e) {
            System.out.println("Список истории запросов пуст.");
        }
    }
}
