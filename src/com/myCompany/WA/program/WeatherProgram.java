package com.myCompany.WA.program;

import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.WeatherView;

import java.util.Scanner;

public class WeatherProgram {

    private static final String EXIT = "finish";
    private static final String HISTORY = "list";

    public void start() {

        CitiesRepository repository = new CitiesRepository();
        WeatherView view = new WeatherView();
        Scanner input = new Scanner(System.in);

        while (true) {
            view.start();

            if (input.hasNextInt()) {
                int historyNumber = input.nextInt() - 1;

                try {
                    view.showCityWeather(repository.getCityByIndex(historyNumber));
                } catch (WeatherProgramException e) {
                    view.showException(e);
                }
            } else {
                String inputString = input.next();

                if(inputString.equals(EXIT)){
                    break;
                }

                if (inputString.equals(HISTORY))  {
                    view.showHistoryRequestCities(repository.getListCities());
                } else {
                    try {
                        view.showCityWeather(repository.getCityByName(inputString));
                    } catch (WeatherProgramException e) {
                        view.showException(e);
                    }
                }
            }
        }
    }
}

