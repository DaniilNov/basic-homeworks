package ru.otus.java.basic.homeworks.hw9;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализуйте метод, принимающий в качестве аргументов числа min и max, и возвращающий ArrayList с набором последовательных значений в указанном диапазоне (min и max включительно, шаг - 1);
 * Реализуйте метод, принимающий в качестве аргумента список целых чисел, суммирующий все элементы, значение которых больше 5, и возвращающий сумму;
 * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, метод должен переписать каждую заполненную ячейку списка указанным числом;
 * Реализуйте метод, принимающий в качестве аргументов целое число и ссылку на список, увеличивающий каждый элемент списка на указанное число;
 * Создайте класс Сотрудник с полями: имя, возраст;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий список их имен;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный возраст, и возвращающий список сотрудников, возраст которых больше либо равен указанному аргументу;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников и минимальный средний возраст, и проверяющий что средний возраст сотрудников превышает указанный аргумент;
 * Реализуйте метод, принимающий в качестве аргумента список сотрудников, и возвращающий ссылку на самого молодого сотрудника.
 */
public class HomeWorkNineMain {
    public static void main(String[] args) {
        /**
         * Демонстрация работы методов с числами
         */
        List<Integer> range = Utils.createRange(1, 10);
        System.out.println("Диапазон: " + range);

        int sum = Utils.sumGreaterThanFive(range);
        System.out.println("Сумма элементов больше 5: " + sum);

        Utils.fillListWithNumber(5, range);
        System.out.println("Список, заполненный числом 5: " + range);

        Utils.incrementListElementsByNumber(3, range);
        System.out.println("Список, увеличенный на 3: " + range);

        /**
         * Демонстрация работы методов с сотрудниками
         */
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Алиса", 30));
        employees.add(new Employee("Боб", 25));
        employees.add(new Employee("Чарли", 35));
        employees.add(new Employee("Диана", 28));

        List<String> employeeNames = Utils.getEmployeeNames(employees);
        System.out.println("Имена сотрудников: " + employeeNames);

        List<Employee> filteredEmployees = Utils.filterEmployeesByMinAge(employees, 30);
        System.out.println("Сотрудники с возрастом >= 30: " + filteredEmployees);

        boolean isAverageAgeGreaterThan30 = Utils.isAverageAgeGreaterThan(employees, 30);
        System.out.println("Средний возраст сотрудников больше 30: " + isAverageAgeGreaterThan30);

        Employee youngestEmployee = Utils.getYoungestEmployee(employees);
        System.out.println("Самый молодой сотрудник: " + youngestEmployee);
    }
}
