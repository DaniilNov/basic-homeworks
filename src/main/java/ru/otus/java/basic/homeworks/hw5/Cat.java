package ru.otus.java.basic.homeworks.hw5;

public class Cat extends Animal {
    public Cat(String name, double runningSpeed, int stamina) {
        super(name, runningSpeed, 0, stamina);
    }

    @Override
    public double run(int distance) {
        if (distance <= stamina) {
            stamina -= distance;
            System.out.println(name + " пробежал " + distance + " м. за " + (distance / runningSpeed) + " сек. Осталось выносливости: " + stamina);
            return distance / runningSpeed;
        } else {
            System.out.println(name + " устал и не может пробежать " + distance + " м");
            return -1;
        }
    }

    @Override
    public double swim(int distance) {
        System.out.println(name + " не умеет плавать.");
        return -1;
    }
}
