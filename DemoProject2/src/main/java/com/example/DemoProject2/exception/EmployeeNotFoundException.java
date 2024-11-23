package com.example.DemoProject2.exception;

public class EmployeeNotFoundException extends RuntimeException {
    private int id;
    public EmployeeNotFoundException(Integer id) {
        super(String.format("Employee With given Id %s is not  present ",id));
        this.id=id;

    }
}
