package ru.otus.java.basic.homeworks.hw5.animals;

public class Cat extends Animal {
    public Cat(String name, double runningSpeed, int stamina) {
        super(name, runningSpeed, 0, stamina);
    }

    @Override
    public double swim(int distance) {
        System.out.println(name + " не умеет плавать.");
        return -1;
    }
}
