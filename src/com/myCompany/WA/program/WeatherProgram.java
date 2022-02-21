package com.myCompany.WA.program;

import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.WeatherView;

import java.util.Scanner;

public class WeatherProgram {

    private static final String EXIT = "finish";
    private static final String HISTORY = "list";
    private static final String HISTORY_NUMBER = "historyNumber";

    CitiesRepository repository = new CitiesRepository();
    WeatherView view = new WeatherView();

    public void start() {

        while (true) {
            view.start();

            String inputData = parseData(view.inputData());

            if (inputData.equals(EXIT)) {
                break;
            }

            switch (inputData) {
                case HISTORY_NUMBER -> getCityByHistoryNumber(view.inputData().nextInt() - 1);
                case HISTORY -> view.showHistoryRequestCities(repository.getListCities());
                default -> getCityByName(inputData);
            }
        }
    }

    private String parseData(Scanner input) {
        if (input.hasNextInt()){
            return HISTORY_NUMBER;
        } else {
            return input.next();
        }
    }

    private void getCityByHistoryNumber(int historyNumber){
        try {
            view.showCityWeather(repository.getCityByIndex(historyNumber));
        } catch (WeatherProgramException e) {
            view.showException(e);
        }
    }

    private void getCityByName(String cityName){
        try {
            view.showCityWeather(repository.getCityByName(cityName));
        } catch (WeatherProgramException e) {
            view.showException(e);
        }
    }

}

