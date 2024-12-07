package com.example.didemo;

import org.springframework.stereotype.Component;

@Component // creates singleton instances
public class SingleTonBean {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }
}
