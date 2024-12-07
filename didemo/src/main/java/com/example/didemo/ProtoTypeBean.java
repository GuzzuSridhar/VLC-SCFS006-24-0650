package com.example.didemo;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ProtoTypeBean {
    private int counter = 0;

    public int getCounter() {
        return counter;
    }

    public void incrementCounter() {
        counter++;
    }
}
