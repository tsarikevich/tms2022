package com.tms.philosophers;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(2);
        for (int i = 0; i < 5; i++) {
            Philosopher philosopher = new Philosopher(semaphore, i);
            philosopher.start();
        }
    }
}
