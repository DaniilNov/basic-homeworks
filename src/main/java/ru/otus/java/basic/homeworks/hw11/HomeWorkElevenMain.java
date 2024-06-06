package ru.otus.java.basic.homeworks.hw11;

public class HomeWorkElevenMain {
    public static void main(String[] args) {
        PersonDataBase personDataBase = new PersonDataBase();

        personDataBase.add(new Person("Иван Иванов", Position.MANAGER, 1L));
        personDataBase.add(new Person("Петр Петров", Position.DRIVER, 2L));
        personDataBase.add(new Person("Сергей Сергеев", Position.DIRECTOR, 3L));
        personDataBase.add(new Person("Алексей Алексеев", Position.DEVELOPER, 4L));
        personDataBase.add(new Person("Мария Алексеева", Position.SENIOR_MANAGER, 5L));
        personDataBase.add(new Person("Анна Иванова", Position.JANITOR, 6L));

        System.out.println("Поиск сотрудника с id 1: " + personDataBase.findById(1L));
        System.out.println("Поиск сотрудника с id 4: " + personDataBase.findById(4L));
        System.out.println("Поиск сотрудника с id 7: " + personDataBase.findById(7L));

        System.out.println("Иван Иванов является менеджером: " + personDataBase.isManager(personDataBase.findById(1L)));
        System.out.println("Петр Петров является менеджером: " + personDataBase.isManager(personDataBase.findById(2L)));

        System.out.println("Сотрудник с id 2 является сотрудником: " + personDataBase.isEmployee(2L));
        System.out.println("Сотрудник с id 3 является сотрудником: " + personDataBase.isEmployee(3L));

        int[] array = {5, 3, 8, 4, 2, 7, 1, 10, 6, 9};

        System.out.println("Исходный массив: ");
        printArray(array);
        ArraySorter.bubbleSort(array);
        System.out.println("Отсортированный массив (пузырьковая сортировка): ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
