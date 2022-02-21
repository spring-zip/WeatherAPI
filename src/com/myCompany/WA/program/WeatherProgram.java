package com.myCompany.WA.program;

import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.WeatherView;

public class WeatherProgram {

    private static final String EXIT = "finish";
    private static final String HISTORY = "list";

    CitiesRepository repository = new CitiesRepository();
    WeatherView view = new WeatherView();

    public void start() {

        while (true) {
            view.start();

            if (view.inputData().hasNextInt()) {
                int historyNumber = view.inputData().nextInt() - 1;
                getCityByHistoryNumber(historyNumber);

            } else {
                String inputString = view.inputData().next();

                if(inputString.equals(EXIT)){
                    break;
                }

                if (inputString.equals(HISTORY))  {
                    view.showHistoryRequestCities(repository.getListCities());
                } else {
                    getCityByName(inputString);
                }
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

