package com.weatherapp.exceptions;

public class EventNotFoundException extends RuntimeException{
    public EventNotFoundException(){
        super("Usuário não encontrado.");
    }

    public EventNotFoundException(String message){
        super(message);
    }
}
