package com.myCompany.WA.view;

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

    public void showHistoryRequestCities(String historyRequest) {
        System.out.println(historyRequest);
    }
}
