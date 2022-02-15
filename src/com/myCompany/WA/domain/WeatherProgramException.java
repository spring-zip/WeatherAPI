package com.myCompany.WA.domain;

public class WeatherProgramException extends Exception {

    private String message;

    public WeatherProgramException(String message){
        this.message = message;
    }

    public String getMessage (){
        return message;
    }
}


