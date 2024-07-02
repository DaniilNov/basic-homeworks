package ru.otus.java.basic.homeworks.hw14;

public class Main {
    public static void main(String[] args) {
        double[] array = new double[100_000_000];

        long startTimeSingleThread = System.nanoTime();
        calculateArrayValuesSingleThread(array);
        long endTimeSingleThread = System.nanoTime();

        System.out.println("Время выполнения одним потоком: " + (endTimeSingleThread - startTimeSingleThread) / 1_000_000 + " мс");

        array = new double[100_000_000];

        long startTimeMultiThread = System.nanoTime();
        calculateArrayValuesMultiThread(array);
        long endTimeMultiThread = System.nanoTime();

        System.out.println("Время выполнения четырьмя потоками: " + (endTimeMultiThread - startTimeMultiThread) / 1_000_000 + " мс");

    }

    private static void calculateArrayValuesSingleThread(double[] array) {

        for (int i = 0; i < array.length; i++) {
            array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    private static void calculateArrayValuesMultiThread(double[] array) {
        int numThreads = 4;
        Thread[] threads = new Thread[numThreads];
        int chunkSize = array.length / numThreads;

        for (int t = 0; t < numThreads; t++) {
            final int start = t * chunkSize;
            final int end = (t == numThreads - 1) ? array.length : start + chunkSize;
            threads[t] = new Thread(() -> {
                for (int i = start; i < end; i++) {
                    array[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                }
            });
            threads[t].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

