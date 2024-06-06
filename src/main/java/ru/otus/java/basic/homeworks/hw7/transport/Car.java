package ru.otus.java.basic.homeworks.hw7.transport;

import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;

public class Car extends Transport {
    private int fuel;

    public Car(String name, int fuel) {
        super(name);
        this.fuel = fuel;
    }

    @Override
    public boolean move(TerrainType terrain, int distance) {
        if (terrain == TerrainType.DENSE_FOREST || terrain == TerrainType.SWAMP) {
            System.out.println("Машина не может перемещаться по " + terrain);
            return false;
        }
        if (fuel >= distance) {
            fuel -= distance;
            System.out.println("Машина проехала " + distance + " км по " + terrain + ". Осталось топлива: " + fuel);
            return true;
        } else {
            System.out.println("Недостаточно топлива для перемещения на " + distance + " км");
            return false;
        }
    }
}
