package ru.otus.java.basic.homeworks.hw7.transport;

import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;

public abstract class Transport {
    public String name;

    protected Transport(String name) {
        this.name = name;
    }

    public abstract boolean move(TerrainType terrain, int distance);
}
