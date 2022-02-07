package com.myCompany.WA.domain;

import java.io.IOException;

public class NoNetworkException extends IOException {

    private String message;

    public NoNetworkException (String message){
        this.message = message;
    }

    public String getMessage (){
        return message;
    }
}


