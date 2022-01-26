package com.myCompany.WA.domain;

public class View {
    CheckListCities check = new CheckListCities();

    public void cityWeather (City city) {
        System.out.println("Город: " + city.getCityName() +
                ". Код страны: " + city.getCountryName() +
                "\nТемпература: " + city.getTempInfo() + "°C" +
                "; Ощущается как: " + city.getTempFeels() + "°C" +
                "\nВлажность: " + city.getHumidity() + "%" +
                "\nДавление: " + city.getPressure() + " мм рт. ст." +
                "\nСкорость ветра: " + city.getWind() + " м/с\n");
    }

    public void cityInfo (int index, ListCities listCities) {
        if (check.isListEmpty(listCities)) {
            System.out.println("Список истории запросов пуст.\n");
        } else if (check.isIndexOutOfBounds(index,listCities)) {
            System.out.println("Введён не верный индекс города. В истории запроса такого города нет.\n");
        } else{
        this.cityWeather(listCities.getListCities().get(index - 1));
        }
    }

    public void listCities (ListCities cities) {
        if (check.isListEmpty(cities)){
            System.out.println("Список истории запросов пуст.\n");
        } else {
            String listCities = "";
            int i;
            for (i = 0; i < cities.getListCities().size(); i++) {
                City city = cities.getListCities().get(i);
                listCities += (i + 1) + ". " + "Город: " + city.getCityName() + ". Код страны: " + city.getCountryName() + "\n";
            }
            System.out.println(listCities);
        }
    }

    public void start (){
        System.out.println("Для выхода введите finish.\n" +
                           "Для вывода истории запросов городов введите list. \n" +
                           "Введите название города: ");
    }
}
