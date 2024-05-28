package ru.otus.java.basic.homeworks.hw5.animals;

public abstract class Animal {
    protected String name;
    protected double runningSpeed;
    protected double swimmingSpeed;
    protected int stamina;

    public Animal(String name, double runningSpeed, double swimmingSpeed, int stamina) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.stamina = stamina;
    }

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

    public abstract double swim(int distance);

    public void info() {
        System.out.println(name + ": скорость бега " + runningSpeed + " м/с, скорость плавания " + swimmingSpeed + " м/с, выносливость " + stamina);
    }
}
