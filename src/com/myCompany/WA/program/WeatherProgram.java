package com.myCompany.WA.program;

import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.WeatherView;

public class WeatherProgram {

    private static final String EXIT = "finish";
    private static final String HISTORY = "list";
    private static final String HISTORY_NUMBER = "historyNumber";

    CitiesRepository repository = new CitiesRepository();
    WeatherView view = new WeatherView();


    public void start() {

        while (true) {
            view.start();

            InputData inputData = new InputData(view.inputData());
            String input = inputData.getCommand();

            switch (input) {
                case EXIT -> {
                    return;
                }
                case HISTORY_NUMBER -> getCityByHistoryNumber(inputData.getHistoryNumber() - 1);
                case HISTORY -> view.showHistoryRequestCities(repository.getListCities());
                default -> getCityByName(input);
            }
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

