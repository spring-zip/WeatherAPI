package com.myCompany.WA.domain;

import java.util.Scanner;

public class WeatherProgram {

    public void start() {

        Scanner input = new Scanner(System.in);
        System.out.println("Для выхода введите finish. \nВведите название города: ");
        ConnectionAvailability checkConnection = new ConnectionAvailability();

        while (true) {
            if (!checkConnection.isNetworkReachable()) {
                System.out.println("Нет подключения к интернету");
                break;
            } else {
                if (input.hasNext()) {
                    String cityName = input.next();

                    if (cityName.equals("finish")) {
                        break;
                    } else {
                        UrlContent cityInfo = new UrlContent();

                        if (cityInfo.getUrlContent(cityName).equals("Такой город не был найден!")) {
                            System.out.println(cityInfo.getUrlContent(cityName));
                            System.out.println();
                            System.out.println("Для выхода введите finish. \nВведите название города: ");
                        } else {
                            Cities city = new Cities(cityName);
                            if (cityInfo.isJsonObjectCorrect(cityName)) {
                                System.out.println(city.getWeather(cityName));
                            } else {
                                System.out.println("Ошибка: ответ сервера не в поном объеме или содержит ошибку");
                            }
                            System.out.println();
                            System.out.println("Для выхода введите finish. \nВведите название города: ");
                        }
                    }
                }
            }
        }
    }
}
