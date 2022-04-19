package com.example.waaonlineminimarketbackend.exceptions;

public class BadRequestException extends Exception {
    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException() {
        this("Bad Request, check input");
    }
}
