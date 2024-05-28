package ru.otus.java.basic.homeworks.hw6.animals;

import ru.otus.java.basic.homeworks.hw6.items.Plate;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;
    }

    public void eat(Plate plate) {
        if (plate.decreaseFood(appetite)) {
            satiety = true;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
