package com.myCompany.WA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;



public class WApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a City: ");

        while (true) {
            if (input.hasNext()) {
                String city = input.next();

                if (city.equals("finish")) {
                    break;
                } else {
                String output = getUrlContent("http://api.openweathermap.org/data/2.5/weather?q=" + city + "&appid=ce1d4b74bf00f8e5d52226428613c523&units=metric");
                    if (output.equals("Такой город не был найден!")) {
                        System.out.println(output);
                    } else {
                        String temp = output.substring(output.indexOf("temp") + 6, output.indexOf("feels_like") - 2);
                        System.out.println("Температура сейчас: " + temp + " градусов Цельсия");
                    }
                }
            }
        }
    }
    private static String getUrlContent(String urlAdress) {
        StringBuffer content = new StringBuffer();

        try {
            URL url = new URL(urlAdress);
            URLConnection urlConn = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            String line;

            while((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch(Exception e) {
            return "Такой город не был найден!";
        }
        return content.toString();
    }

}
