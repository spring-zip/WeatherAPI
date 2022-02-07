package com.myCompany.WA;

import com.myCompany.WA.domain.NoNetworkException;
import com.myCompany.WA.program.WeatherProgram;

public class WApp {
    public static void main(String[] args) {
        WeatherProgram program = new WeatherProgram();
        program.start();
    }
}
