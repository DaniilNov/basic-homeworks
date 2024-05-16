package ru.otus.java.basic.homeworks.hw5;

public class Dog extends Animal {
    public Dog(String name, double runningSpeed, double swimmingSpeed, int stamina) {
        super(name, runningSpeed, swimmingSpeed, stamina);
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
        int requiredStamina = distance * 2;
        if (requiredStamina <= stamina) {
            stamina -= requiredStamina;
            System.out.println(name + " проплыл " + distance + " м. за " + (distance / swimmingSpeed) + " сек. Осталось выносливости: " + stamina);
            return distance / swimmingSpeed;
        } else {
            System.out.println(name + " устал и не может проплыть " + distance + " м.");
            return -1;
        }
    }
}
