package ru.otus.java.basic.homeworks.hw7.animals;

import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;
import ru.otus.java.basic.homeworks.hw7.transport.Transport;

public class Horse extends Transport {
    private int stamina;

    public Horse(String name, int stamina) {
        super(name);
        this.stamina = stamina;
    }

    @Override
    public boolean move(TerrainType terrain, int distance) {
        if (terrain == TerrainType.SWAMP) {
            System.out.println("Лошадь не может перемещаться по " + terrain);
            return false;
        }
        if (stamina >= distance) {
            stamina -= distance;
            System.out.println("Лошадь пробежала " + distance + " км по " + terrain + ". Осталось выносливости: " + stamina);
            return true;
        } else {
            System.out.println("Лошади не хватает выносливости для перемещения на " + distance + " км");
            return false;
        }
    }
}
