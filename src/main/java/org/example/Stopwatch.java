package org.example;

import java.util.concurrent.TimeUnit;

public class Stopwatch {
    private double startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public double stop() {
        double endTime = System.nanoTime();
        double elapsedTimeInNanos = endTime - startTime;
        return elapsedTimeInNanos/1000000;
    }
}

