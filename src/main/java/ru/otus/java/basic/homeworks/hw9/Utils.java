package ru.otus.java.basic.homeworks.hw9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Utils {

    /**
     * Метод для создания списка последовательных значений в указанном диапазоне
     */
    public static List<Integer> createRange(int min, int max) {
        List<Integer> range = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            range.add(i);
        }
        return range;
    }

    /**
     * Метод для суммирования всех элементов списка, значение которых больше 5
     */
    public static int sumGreaterThanFive(List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        return list.stream()
                .filter(num -> num > 5)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Метод для переписывания каждой заполненной ячейки списка указанным числом
     */
    public static void fillListWithNumber(int number, List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, number);
        }
    }

    /**
     * Метод для увеличения каждого элемента списка на указанное число
     */
    public static void incrementListElementsByNumber(int number, List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + number);
        }
    }

    /**
     * Метод для получения списка имен сотрудников
     */
    public static List<String> getEmployeeNames(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list cannot be null");
        }
        return employees.stream()
                .filter(Objects::nonNull)
                .map(Employee::getName)
                .toList();
    }

    /**
     * Метод для получения списка сотрудников, возраст которых больше либо равен указанному аргументу
     */
    public static List<Employee> filterEmployeesByMinAge(List<Employee> employees, int minAge) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list cannot be null");
        }
        return employees.stream()
                .filter(Objects::nonNull)
                .filter(employee -> employee.getAge() >= minAge)
                .toList();
    }

    /**
     * Метод для проверки, что средний возраст сотрудников превышает указанный аргумент
     */
    public static boolean isAverageAgeGreaterThan(List<Employee> employees, double minAverageAge) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list cannot be null");
        }
        return employees.stream()
                .filter(Objects::nonNull)
                .mapToInt(Employee::getAge)
                .average()
                .orElse(0) > minAverageAge;
    }

    /**
     * Метод для получения самого молодого сотрудника
     */
    public static Employee getYoungestEmployee(List<Employee> employees) {
        if (employees == null) {
            throw new IllegalArgumentException("Employee list cannot be null");
        }
        return employees.stream()
                .filter(Objects::nonNull)
                .min(Comparator.comparingInt(Employee::getAge))
                .orElse(null);
    }
}