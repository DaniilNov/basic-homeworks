package ru.otus.java.basic.homeworks.hw3;

public class HomeWorkThreeMain {
    public static void main(String[] args) {

        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, -9}
        };

        int[][] arrayWithOneRow = {
                {1, 2, 3}
        };

        System.out.println(sumOfPositiveElements(array));
        printSquare(array.length);
        zeroDiagonalsAndPrintArray(array);
        System.out.println(findMax(array));
        System.out.println(sumOfSecondRow(array));
        System.out.println(sumOfSecondRow(arrayWithOneRow));
    }

    //Реализовать метод sumOfPositiveElements(..), принимающий в качестве аргумента
    // целочисленный двумерный массив, метод должен посчитать и
    // вернуть сумму всех элементов массива, которые больше 0;
    public static int sumOfPositiveElements(int[][] arrayInt) {
        int sumInt = 0;
        for (int[] ints : arrayInt) {
            int rowSum = 0;
            for (int anInt : ints) {
                if (anInt > 0) {
                    rowSum += anInt;
                }
            }
            sumInt += rowSum;
        }
        return sumInt;
    }

    //Реализовать метод, который принимает в качестве аргумента
    // int size и печатает в консоль квадрат из
    // символов * со сторонами соответствующей длины;
    public static void printSquare(int size) {
        for (int a = 0; a < size; a++) {
            for (int i = 0; i < size; i++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //Реализовать метод, принимающий в качестве аргумента двумерный целочисленный массив,
    // и зануляющий его диагональные элементы
    // (можете выбрать любую из диагоналей, или занулить обе);
    public static void zeroDiagonalsAndPrintArray(int[][] arrayInt) {
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i][i] = 0;
            arrayInt[i][arrayInt.length - 1 - i] = 0;
        }
        for (int[] row : arrayInt) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    //Реализовать метод findMax(int[][] array)
    // который должен найти и вернуть максимальный элемент массива;
    public static int findMax(int[][] array) {
        int maxValue = array[0][0];
        for (int[] row : array) {
            for (int element : row) {
                if (element > maxValue) {
                    maxValue = element;
                }
            }
        }
        return maxValue;
    }

    //Реализуйте метод, который считает сумму элементов второй строки двумерного массива,
    // если второй строки не существует, то в качестве результата необходимо вернуть -1
    public static int sumOfSecondRow(int[][] array) {
        if (array.length < 2) {
            return -1;
        }
        int sum = 0;
        for (int element : array[1]) {
            sum += element;
        }
        return sum;
    }
}
