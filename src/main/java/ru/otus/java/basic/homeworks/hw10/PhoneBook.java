package ru.otus.java.basic.homeworks.hw10;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Реализуйте класс PhoneBook, который хранит в себе список имен (фио) и телефонных номеров;
 * Метод add() должен позволять добавлять запись имя-телефон;
 * Метод find() выполнять поиск номер(-а, -ов) телефона по имени;
 * Под одним именем может быть несколько телефонов
 * (в случае однофамильцев, или наличии у одного человека нескольких номеров),
 * тогда при запросе такой фамилии должны выводиться все телефоны;
 * Метод containsPhoneNumber должен проверять наличие телефона в справочнике.
 */
public class PhoneBook {
    private final Map<String, List<String>> contacts;

    public PhoneBook() {
        this.contacts = new HashMap<>();
    }

    /**
     * Метод для добавления записи имя-телефон
     */
    public void add(String name, String phoneNumber) {
        contacts.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNumber);
    }

    /**
     * Метод для поиска номеров телефонов по имени
     */
    public List<String> find(String name) {
        return contacts.getOrDefault(name, new ArrayList<>());
    }

    /**
     * Метод для проверки наличия телефона в справочнике
     */
    public boolean containsPhoneNumber(String phoneNumber) {
        return contacts.values().stream()
                .flatMap(List::stream)
                .anyMatch(phone -> phone.equals(phoneNumber));
    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Иван Иванов", "123-456-7890");
        phoneBook.add("Иван Иванов", "098-765-4321");
        phoneBook.add("Петр Петров", "555-555-5555");

        System.out.println("Телефоны Ивана Иванова: " + phoneBook.find("Иван Иванов"));
        System.out.println("Телефоны Петра Петрова: " + phoneBook.find("Петр Петров"));
        System.out.println("Телефоны Сергея Сергеевича: " + phoneBook.find("Сергей Сергеевич"));

        System.out.println("Содержит ли телефон 123-456-7890: " + phoneBook.containsPhoneNumber("123-456-7890"));
        System.out.println("Содержит ли телефон 111-111-1111: " + phoneBook.containsPhoneNumber("111-111-1111"));
    }
}
