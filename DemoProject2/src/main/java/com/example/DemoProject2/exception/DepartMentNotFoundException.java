package com.example.DemoProject2.exception;

public class DepartMentNotFoundException extends RuntimeException {
    private int id;
    public DepartMentNotFoundException(Integer dId) {
        super(String.format("Department with Id %s is not present ",dId))
        ;
        this.id=dId;

    }
}
