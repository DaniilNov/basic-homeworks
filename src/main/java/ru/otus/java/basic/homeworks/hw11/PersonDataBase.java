package ru.otus.java.basic.homeworks.hw11;

import java.util.HashMap;
import java.util.Map;

public class PersonDataBase {
    private final Map<Long, Person> personMap;

    public PersonDataBase() {
        this.personMap = new HashMap<>();
    }

    /**
     * Метод для поиска Person по id - O(1)
     */
    public Person findById(Long id) {
        return personMap.get(id);
    }

    /**
     * Метод для добавления Person - O(1)
     */
    public void add(Person person) {
        personMap.put(person.getId(), person);
    }

    /**
     * Метод для проверки, является ли Person менеджером - O(1)
     */
    public boolean isManager(Person person) {
        Position position = person.getPosition();
        return position == Position.MANAGER || position == Position.DIRECTOR ||
                position == Position.BRANCH_DIRECTOR || position == Position.SENIOR_MANAGER;
    }

    /**
     * Метод для проверки, является ли Person сотрудником - O(1)
     */
    public boolean isEmployee(Long id) {
        Person person = findById(id);
        if (person == null) {
            return false;
        }
        Position position = person.getPosition();
        return position != Position.MANAGER && position != Position.DIRECTOR &&
                position != Position.BRANCH_DIRECTOR && position != Position.SENIOR_MANAGER;
    }
}
