package com.myCompany.WA;


import java.util.Scanner;
import static com.myCompany.WA.domain.UrlContent.*;
import static com.myCompany.WA.domain.ConnectionAvailability.*;
import static com.myCompany.WA.domain.WorkWithJSon.parseJson;


public class WApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Для выхода введите finish. \nВведите название города: ");

        while (true) {
            if (!isWebsiteReachable("https://openweathermap.org/")) {
                System.out.println("Нет подключения к интернету или связи с сайтом погоды");
                break;
            } else {
                if (input.hasNext()) {
                    String city = input.next();

                    if (city.equals("finish")) {
                        break;
                    } else {
                        String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q="
                                + city + "&appid=ce1d4b74bf00f8e5d52226428613c523&units=metric&lang=ru");
                        ///

                        if (output.equals("Такой город не был найден!")) {
                            System.out.println(output);
                            System.out.println();
                            System.out.println("Для выхода введите finish. \nВведите название города: ");
                        } else {
                            String wetherInfo = parseJson(output);
                            System.out.println(wetherInfo);
                            System.out.println();
                            System.out.println("Для выхода введите finish. \nВведите название города: ");
                        }
                    }
                }
            }
        }
    }
}
