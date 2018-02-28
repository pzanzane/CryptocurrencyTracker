package com.clevertrap.cryptocurrencytracker.client;


public class ErrorBody {

    private String message = null;

    public ErrorBody(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
