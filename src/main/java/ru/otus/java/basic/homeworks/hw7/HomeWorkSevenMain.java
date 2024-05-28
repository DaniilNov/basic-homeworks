package ru.otus.java.basic.homeworks.hw7;

import ru.otus.java.basic.homeworks.hw7.animals.Horse;
import ru.otus.java.basic.homeworks.hw7.human.Human;
import ru.otus.java.basic.homeworks.hw7.terrain.TerrainType;
import ru.otus.java.basic.homeworks.hw7.transport.AllTerrainVehicle;
import ru.otus.java.basic.homeworks.hw7.transport.Bicycle;
import ru.otus.java.basic.homeworks.hw7.transport.Car;


//Создайте класс Человек с полями name (имя) и currentTransport (текущий транспорт)
//Реализуйте в вашем приложении классы Машина, Лошадь, Велосипед, Вездеход
//Каждый из классов должен предоставлять возможность перемещаться на определенное расстояние с указанием типа местности
//В приложении должны быть типы местности: густой лес, равнина, болото
//Человек должен иметь возможность сесть на любой из этих видов транспорта, встать с него, или переместиться на некоторое расстояние (при условии что он находится на каком-либо транспорте)
//При попытке выполнить перемещение у человека, не использующего транспорт, считаем что он просто идет указанное расстояние пешком
//При перемещении Машина и Вездеход тратят бензин, который у них ограничен. Лошадь тратит силы. Велосипед может использоваться без ограничений (можете для усложнения велосипедом тратить силы “водителя”). При выполнении действия результат должен быть отпечатан в консоль
//У каждого вида транспорта есть местности по которым он не может перемещаться: машина - густой лес и болото, лошадь и велосипед - болото, вездеход - нет ограничений
//При попытке переместиться должен быть возвращен результат true/false - удалось ли выполнить действие
public class HomeWorkSevenMain {
    public static void main(String[] args) {
        Human human = new Human("Иван");

        Car car = new Car("Машина", 50);
        Horse horse = new Horse("Лошадь", 30);
        Bicycle bicycle = new Bicycle("Велосипед");
        AllTerrainVehicle atv = new AllTerrainVehicle("Вездеход", 100);

        human.setTransport(car);
        human.move(TerrainType.PLAIN, 20);
        human.move(TerrainType.DENSE_FOREST, 10);
        human.removeTransport();

        human.setTransport(horse);
        human.move(TerrainType.PLAIN, 15);
        human.move(TerrainType.SWAMP, 5);
        human.removeTransport();

        human.setTransport(bicycle);
        human.move(TerrainType.PLAIN, 10);
        human.move(TerrainType.SWAMP, 5);
        human.removeTransport();

        human.setTransport(atv);
        human.move(TerrainType.PLAIN, 50);
        human.move(TerrainType.SWAMP, 30);
        human.removeTransport();

        human.move(TerrainType.PLAIN, 5);
    }
}
