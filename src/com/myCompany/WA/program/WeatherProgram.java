package com.myCompany.WA.program;

import com.myCompany.WA.controller.Controller;
import com.myCompany.WA.domain.WeatherProgramException;
import com.myCompany.WA.view.WeatherView;

public class WeatherProgram {

    private static final String EXIT = "finish";
    private static final String HISTORY = "list";

    public void start() {

        WeatherView view = new WeatherView();
        Controller controller = new Controller();

        while (true) {
            view.start();

            if (controller.inputData().hasNextInt()) {
                int historyNumber = controller.inputData().nextInt() - 1;

                try {
                    view.showCityWeather(controller.getCityByIndex(historyNumber));
                } catch (WeatherProgramException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                String inputString = controller.inputData().next();

                if(inputString.equals(EXIT)){
                    break;
                }

                if (inputString.equals(HISTORY))  {
                    view.showHistoryRequestCities(controller.getHistoryRequestCities());
                } else {
                    view.showCityWeather(controller.getCityByName(inputString));
                }
            }
        }
    }
}

