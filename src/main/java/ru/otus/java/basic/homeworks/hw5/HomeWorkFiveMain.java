package ru.otus.java.basic.homeworks.hw5;

import ru.otus.java.basic.homeworks.hw5.animals.Cat;
import ru.otus.java.basic.homeworks.hw5.animals.Dog;
import ru.otus.java.basic.homeworks.hw5.animals.Horse;

// Создайте классы Cat, Dog и Horse с наследованием от класса Animal
// У каждого животного есть имя, скорость бега и плавания (м/с), и выносливость (измеряется в условных единицах)
// Затраты выносливости:
// Все животные на 1 метр бега тратят 1 ед выносливости,
// Собаки на 1 метр плавания - 2 ед.
// Лошади на 1 метр плавания тратят 4 единицы
// Кот плавать не умеет.
// Реализуйте методы run(int distance) и swim(int distance), которые должны возвращать время, затраченное на указанное действие, и “понижать выносливость” животного. Если выносливости не хватает, то возвращаем время -1 и указываем что у животного появилось состояние усталости. При выполнении действий пишем сообщения в консоль.
// Добавляем метод info(), который выводит в консоль состояние животного.
public class HomeWorkFiveMain {
    public static void main(String[] args) {
        Cat cat = new Cat("Барсик", 10, 100);
        Dog dog = new Dog("Барбос", 8, 2, 200);
        Horse horse = new Horse("Спирит", 20, 5, 300);

        System.out.println("Кот:");
        cat.info();
        cat.run(50);
        cat.swim(10);
        cat.run(60);
        System.out.println();

        System.out.println("Собака:");
        dog.info();
        dog.run(100);
        dog.swim(50);
        dog.run(150);
        dog.swim(100);
        System.out.println();

        System.out.println("Лошадь:");
        horse.info();
        horse.run(200);
        horse.swim(50);
        horse.run(150);
        horse.swim(100);
    }

}

