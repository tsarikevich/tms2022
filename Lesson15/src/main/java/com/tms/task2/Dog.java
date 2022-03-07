package com.tms.task2;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@ToString
@Getter
public class Dog extends Animal implements Serializable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String say() {
        return "Гав-гав";
    }
}
