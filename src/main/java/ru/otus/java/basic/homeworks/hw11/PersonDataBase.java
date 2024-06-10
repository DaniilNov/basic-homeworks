package ru.otus.java.basic.homeworks.hw11;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PersonDataBase {
    private final Map<Long, Person> personMap;
    private static final Set<Position> MANAGER_POSITIONS = EnumSet.of(
            Position.MANAGER,
            Position.DIRECTOR,
            Position.BRANCH_DIRECTOR,
            Position.SENIOR_MANAGER
    );

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
        if (person == null || person.getPosition() == null) {
            return false;
        }
        return MANAGER_POSITIONS.contains(person.getPosition());
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
        return !MANAGER_POSITIONS.contains(position);
    }
}
