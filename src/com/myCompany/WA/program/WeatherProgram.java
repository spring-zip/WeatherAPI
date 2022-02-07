package com.myCompany.WA.program;

import com.myCompany.WA.controller.Controller;
import com.myCompany.WA.repository.CitiesRepository;
import com.myCompany.WA.view.ClientCenterView;

public class WeatherProgram {

    final String EXIT = "finish";
    final String HISTORY = "list";

    public void start() {

        ClientCenterView view = new ClientCenterView();
        Controller controller = new Controller();
        CitiesRepository cities = new CitiesRepository();



        while (true) {
            view.start();

            if (controller.inputData().hasNextInt()) {
                int historyNumber = controller.inputData().nextInt() - 1;
                view.showCityInfoByHistoryNumber(historyNumber, cities);
            } else {
                String inputString = controller.inputData().next();

                if(inputString.equals(EXIT)){
                    break;
                }

                if (inputString.equals(HISTORY))  {
                    view.showHistoryRequestCities(cities);
                } else {
                    view.showCityInfo(controller.getIndexCityByName(inputString, cities), cities);
                }
            }
        }
    }
}

