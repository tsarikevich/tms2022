package com.tms.task2;


import lombok.Getter;

@Getter
public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String say();
}
