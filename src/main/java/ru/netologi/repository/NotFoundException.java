package ru.netologi.repository;

public class NotFoundException extends RuntimeException{

    public NotFoundException(String msg) {
        super(msg);
    }

}
