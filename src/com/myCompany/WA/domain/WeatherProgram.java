package com.myCompany.WA.domain;

import java.util.Scanner;

public class WeatherProgram {

    public void start() {

        Scanner input = new Scanner(System.in);
        ListCities cities = new ListCities();
        CheckListCities check = new CheckListCities();

        while (true) {
            System.out.println("Для выхода введите finish. \n" +
                               "Для вывода истории запросов городов введите list. \n" +
                               "Введите название города: ");

            if (input.hasNextInt()) {
                int listIndex = input.nextInt();
                if (check.isListEmpty(cities)){
                    System.out.println("Список истории запросов пуст.\n");
                } else if (check.isIndexOutOfBounds(listIndex, cities)){
                    System.out.println("Введён не верный индекс города. В истории запроса такого города нет.\n");
                } else {
                System.out.println(cities.getCityWeather(listIndex));
                }

            } else if (input.hasNext()) {
                String cityName = input.next();

                if (cityName.equals("finish")) {
                    break;

                } else if (cityName.equals("list")) {
                    if (check.isListEmpty(cities)){
                        System.out.println("Список истории запросов пуст.");
                    }
                    System.out.println(cities.getListCities());

                } else {
                    ConnectionAvailability checkConnection = new ConnectionAvailability();
                    UrlContent cityInfo = new UrlContent();
                    ParseJson jsonCity = new ParseJson();

                    if (!checkConnection.isNetworkReachable()) {
                        System.out.println("Нет подключения к интернету\n");
                    } else {

                        if (cityInfo.getUrlContent(cityName).equals("Такой город не был найден!\n")) {
                            System.out.println(cityInfo.getUrlContent(cityName));

                        } else {

                            if (jsonCity.isJsonObjectCorrect(cityName)) {
                                City city = new City(jsonCity);
                                if (check.isNoCityInList(city, cities)){
                                cities.setListCities(city);
                                }
                                System.out.println(city.getWeather());

                            } else {
                                System.out.println("Ошибка: ответ сервера не в поном объеме или содержит ошибку\n");
                            }
                        }
                    }
                }
            }
        }
    }
}
