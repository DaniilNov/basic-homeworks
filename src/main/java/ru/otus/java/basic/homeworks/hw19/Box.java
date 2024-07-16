package ru.otus.java.basic.homeworks.hw19;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public double getWeight() {
        double totalWeight = 0.0;
        for (T fruit : fruits) {
            totalWeight += fruit.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box<?> otherBox) {
        return Double.compare(this.getWeight(), otherBox.getWeight()) == 0;
    }

    public void transferFruitsTo(Box<? super T> otherBox) {
        if (otherBox == null) {
            throw new IllegalArgumentException("Target box cannot be null");
        }
        if (this == otherBox) {
            return;
        }
        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }
}

