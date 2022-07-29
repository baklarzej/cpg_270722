package com.pivovarit.movies;

public class HelloWorldService {

    private final String message;

    public HelloWorldService(String message) {
        this.message = message;
    }

    public void hello() {
        System.out.println(message);
    }
}
