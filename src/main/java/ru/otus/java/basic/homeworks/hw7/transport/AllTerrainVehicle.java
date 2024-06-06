package ru.otus.java.basic.homeworks.hw7.transport;

import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;

public class AllTerrainVehicle extends Transport {
    private int fuel;

    public AllTerrainVehicle(String name, int fuel) {
        super(name);
        this.fuel = fuel;
    }

    @Override
    public boolean move(TerrainType terrain, int distance) {
        if (fuel >= distance) {
            fuel -= distance;
            System.out.println("Вездеход проехал " + distance + " км по " + terrain + ". Осталось топлива: " + fuel);
            return true;
        } else {
            System.out.println("Недостаточно топлива для перемещения на " + distance + " км");
            return false;
        }
    }
}
