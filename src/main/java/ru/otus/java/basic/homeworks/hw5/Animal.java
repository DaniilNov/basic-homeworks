package ru.otus.java.basic.homeworks.hw5;

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

    public abstract double run(int distance);

    public abstract double swim(int distance);

    public void info() {
        System.out.println(name + ": скорость бега " + runningSpeed + " м/с, скорость плавания " + swimmingSpeed + " м/с, выносливость " + stamina);
    }
}
