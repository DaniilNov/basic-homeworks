package ru.otus.java.basic.homeworks.hw1;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkOneMain {
    public static void main(String[] args) {
        System.out.println(greetings());
        System.out.println(checkSign(1, -2, -3));
        System.out.println(selectColor());
        System.out.println(compareNumbers());
        System.out.println(addOrSubtractAndPrint(1, 2, true));
        System.out.println(selectMethodBasedOnInput());
    }

    public static String greetings() {
        return "Hello\nWorld\nfrom\nJava";
    }

    public static String checkSign(int a, int b, int c) {
        int sum = a + b + c;
        if (sum >= 0) {
            return "Сумма положительная";
        }
        return "Сумма отрицательная";
    }

    public static String selectColor() {
        int data = 40;
        if (data <= 10) {
            return "Красный";
        } else if (data <= 20) {
            return "Желтый";
        }
        return "Зеленый";
    }

    public static String compareNumbers() {
        int a = 3;
        int b = 2;
        if (a >= b) {
            return "a >= b";
        }
        return "a < b";
    }

    public static int addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        if (increment) {
            return initValue + delta;
        }
        return initValue - delta;
    }

    public static String selectMethodBasedOnInput() {
        Random random = new Random();
        int randomIntOne = random.nextInt(100);
        int randomIntTwo = random.nextInt(100);
        int randomIntThree = random.nextInt(100);
        boolean randomBoolean = random.nextBoolean();
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Введите число от 1 до 5");
            int userInputNumber = sc.nextInt();
            return switch (userInputNumber) {
                case 1 -> greetings();
                case 2 -> checkSign(randomIntOne, randomIntTwo, randomIntThree);
                case 3 -> selectColor();
                case 4 -> compareNumbers();
                case 5 -> String.valueOf(addOrSubtractAndPrint(randomIntOne, randomIntTwo, randomBoolean));
                default -> "Вы ввели число не в диапазоне от 1 до 5";
            };
        }
    }

}
