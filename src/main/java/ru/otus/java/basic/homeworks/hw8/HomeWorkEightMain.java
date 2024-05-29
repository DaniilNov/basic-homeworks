package ru.otus.java.basic.homeworks.hw8;

import ru.otus.java.basic.homeworks.hw8.exceptions.AppArrayDataException;
import ru.otus.java.basic.homeworks.hw8.exceptions.AppArraySizeException;

/**\
 * Реализуйте метод, аргументом которого является двумерный строковый массив размером 4х4.
 * Если передан массив другого размера необходимо бросить исключение AppArraySizeException.
 * Метод должен обойти все элементы массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось (например, в ячейке лежит текст вместо числа),
 * должно быть брошено исключение AppArrayDataException с детализацией, в какой именно ячейке лежат неверные данные.
 * В методе main() необходимо вызвать полученный метод, обработать возможные исключения
 * AppArraySizeException и AppArrayDataException и вывести результат расчета (сумму элементов, при условии что подали на вход корректный массив).
 */
public class HomeWorkEightMain {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidSizeArray = {
                {"1", "2", "3"},
                {"4", "5", "6"},
                {"7", "8", "9"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "eleven", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int sum = ArrayProcessor.processArray(validArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            int sum = ArrayProcessor.processArray(invalidSizeArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e.getMessage());
        }

        try {
            int sum = ArrayProcessor.processArray(invalidDataArray);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (AppArraySizeException | AppArrayDataException e) {
            System.err.println(e.getMessage());
        }
    }
}
