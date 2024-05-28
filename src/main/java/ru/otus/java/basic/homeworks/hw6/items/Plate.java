package ru.otus.java.basic.homeworks.hw6.items;

public class Plate {
    private final int maxFood;
    private int currentFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.currentFood = maxFood;
    }

    public void addFood(int amount) {
        currentFood = Math.min(currentFood + amount, maxFood);
    }

    public boolean decreaseFood(int amount) {
        if (currentFood >= amount) {
            currentFood -= amount;
            return true;
        }
        return false;
    }

    public int getCurrentFood() {
        return currentFood;
    }
}
