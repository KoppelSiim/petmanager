package com.wisercat.petmanagement.exception;

public class PetNotFoundExeption extends RuntimeException{
    public PetNotFoundExeption(String message){
        super (message);
    }
}