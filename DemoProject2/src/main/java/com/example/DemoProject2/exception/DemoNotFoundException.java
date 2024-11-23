package com.example.DemoProject2.exception;

public class DemoNotFoundException extends RuntimeException{
    private int id;
    public DemoNotFoundException(Integer id) {

        super(String.format("Demo with %s id is not present ",id));
        this.id=id;
    }
}
