package com.myCompany.WA.program;

import com.myCompany.WA.controller.Controller;
<<<<<<< HEAD
import com.myCompany.WA.domain.NoNetworkException;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.WeatherView;

public class WeatherProgram {

    private static final String EXIT = "finish";
    private static final String HISTORY = "list";

    public void start() {

        WeatherView view = new WeatherView();
        Controller controller = new Controller();
        CitiesRepository listCities = new CitiesRepository();
=======
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.ClientCenterView;

public class WeatherProgram {

    final String EXIT = "finish";
    final String HISTORY = "list";

    public void start() {

        ClientCenterView view = new ClientCenterView();
        Controller controller = new Controller();
        CitiesRepository cities = new CitiesRepository();


>>>>>>> origin/master

        while (true) {
            view.start();

            if (controller.inputData().hasNextInt()) {
                int historyNumber = controller.inputData().nextInt() - 1;
<<<<<<< HEAD
                try {
                    view.showCityWeather(controller.getCityByIndex(historyNumber, listCities));
                } catch (NoNetworkException e) {
                    System.out.println(e.getMessage());
                }
=======
                view.showCityInfoByHistoryNumber(historyNumber, cities);
>>>>>>> origin/master
            } else {
                String inputString = controller.inputData().next();

                if(inputString.equals(EXIT)){
                    break;
                }

                if (inputString.equals(HISTORY))  {
<<<<<<< HEAD
                    view.showHistoryRequestCities(listCities);
                } else {
                    try {
                        view.showCityWeather(controller.getCityByName(inputString, listCities));
                    } catch (NoNetworkException e) {
                        System.out.println(e.getMessage());
                    }
=======
                    view.showHistoryRequestCities(cities);
                } else {
                    view.showCityInfo(controller.getIndexCityByName(inputString, cities), cities);
>>>>>>> origin/master
                }
            }
        }
    }
}

