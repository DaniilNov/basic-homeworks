package ru.otus.java.basic.homeworks.hw21;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchronizedPrinting {
    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(3)) {
            Object monitor = new Object();

            executor.submit(new PrintTask('A', monitor, "A", "B"));
            executor.submit(new PrintTask('B', monitor, "B", "C"));
            executor.submit(new PrintTask('C', monitor, "C", "A"));
        }
    }
}