package ru.otus.java.basic.homeworks.hw7.human;

import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;
import ru.otus.java.basic.homeworks.hw7.transport.Transport;

public class Human {
    private String name;
    private Transport currentTransport;

    public Human(String name) {
        this.name = name;
        this.currentTransport = null;
    }

    public void setTransport(Transport transport) {
        this.currentTransport = transport;
        System.out.println(name + " сел на " + transport.name);
    }

    public void removeTransport() {
        if (currentTransport != null) {
            System.out.println(name + " слез с " + currentTransport.name);
            currentTransport = null;
        } else {
            System.out.println(name + " не использует транспорт");
        }
    }

    public boolean move(TerrainType terrain, int distance) {
        if (currentTransport != null) {
            return currentTransport.move(terrain, distance);
        } else {
            System.out.println(name + " идет пешком " + distance + " км по " + terrain);
            return true;
        }
    }
}
