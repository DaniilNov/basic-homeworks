package ru.otus.java.basic.homeworks.hw7.transport;

import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;

public class Bicycle extends Transport {

    public Bicycle(String name) {
        super(name);
    }

    @Override
    public boolean move(TerrainType terrain, int distance) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Велосипед не может перемещаться по " + terrain);
            return false;
        }
        System.out.println("Велосипед проехал " + distance + " км по " + terrain);
        return true;
    }
}
