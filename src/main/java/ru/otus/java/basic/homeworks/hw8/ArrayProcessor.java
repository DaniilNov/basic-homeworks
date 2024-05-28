package ru.otus.java.basic.homeworks.hw8;

import ru.otus.java.basic.homeworks.hw8.exceptions.AppArrayDataException;
import ru.otus.java.basic.homeworks.hw8.exceptions.AppArraySizeException;

public class ArrayProcessor {

    public static int processArray(String[][] array) {
        if (array.length != 4 || array[0].length != 4) {
            throw new AppArraySizeException("Массив должен быть размером 4x4");
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException("Ошибка в данных массива в ячейке [" + i + "][" + j + "]: " + array[i][j]);
                }
            }
        }
        return sum;
    }
}
