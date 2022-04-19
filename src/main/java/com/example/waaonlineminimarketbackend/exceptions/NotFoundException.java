package com.example.waaonlineminimarketbackend.exceptions;

public class NotFoundException extends Exception {
    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException() {
        this("Resource not Found");
    }
}
