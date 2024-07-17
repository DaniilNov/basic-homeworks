package ru.otus.java.basic.homeworks.hw22;

import java.util.Arrays;

public class ArrayUtils {

    /**
     * Возвращает новый массив, содержащий элементы исходного массива,
     * идущие после последней единицы
     */
    public static int[] getElementsAfterLastOne(int[] array) {
        int lastIndex = -1;
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 1) {
                lastIndex = i;
                break;
            }
        }
        if (lastIndex == -1) {
            throw new RuntimeException("Array does not contain any 1s");
        }
        return Arrays.copyOfRange(array, lastIndex + 1, array.length);
    }

    /**
     * проверяет, что массив состоит только из чисел 1 и 2
     * и содержит хотя бы одну единицу и одну двойку
     */
    public static boolean isArrayValid(int[] array) {
        boolean hasOne = false;
        boolean hasTwo = false;
        for (int num : array) {
            if (num != 1 && num != 2) {
                return false;
            }
            if (num == 1) {
                hasOne = true;
            }
            if (num == 2) {
                hasTwo = true;
            }
        }
        return hasOne && hasTwo;
    }
}
