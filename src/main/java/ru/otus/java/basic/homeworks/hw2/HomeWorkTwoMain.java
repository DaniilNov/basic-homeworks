package ru.otus.java.basic.homeworks.hw2;

import java.util.Arrays;

public class HomeWorkTwoMain {
    public static void main(String[] args) {
        printStringMultipleTimes("Hello", 2);
        sumAndPrintIfGreaterThanFive(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        fillArrayWithNumber(10, new int[4]);
        incrementArrayElementsByNumber(10, new int[]{1, 2, 3, 4, 5});
        compareSumsOfArrayHalves(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    public static void printStringMultipleTimes(String string, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(string);
        }
    }

    public static void sumAndPrintIfGreaterThanFive(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            if (num > 5) {
                sum += num;
            }
        }
        System.out.println(sum);
    }

    public static void fillArrayWithNumber(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = num;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void incrementArrayElementsByNumber(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] += num;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void compareSumsOfArrayHalves(int[] arr) {
        int firstHalfSum = 0;
        int secondHalfSum = 0;

        for (int i = 0; i < arr.length / 2; i++) {
            firstHalfSum += arr[i];
        }
        for (int i = arr.length / 2; i < arr.length; i++) {
            secondHalfSum += arr[i];
        }
        if (firstHalfSum > secondHalfSum) {
            System.out.println("Сумма элементов первой половины массива больше.");
        } else if (secondHalfSum > firstHalfSum) {
            System.out.println("Сумма элементов второй половины массива больше.");
        } else {
            System.out.println("Суммы элементов обеих половин массива равны.");
        }
    }

}


