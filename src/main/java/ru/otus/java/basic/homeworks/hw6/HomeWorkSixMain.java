package ru.otus.java.basic.homeworks.hw6;


import ru.otus.java.basic.homeworks.hw6.animals.Cat;
import ru.otus.java.basic.homeworks.hw6.items.Plate;

//Реализуйте классы Тарелка (максимальное количество еды, текущее количество еды) и Кот (имя, аппетит). Количество еды измеряем в условных единицах.
//При создании тарелки указывается ее объем и она полностью заполняется едой
//В тарелке должен быть метод, позволяющий добавить еду в тарелку. После добавления в тарелке не может оказаться еды больше максимума
//В тарелке должен быть boolean метод уменьшения количества еды, при этом после такого уменьшения, в тарелке не может оказаться отрицательное количество еды (если удалось уменьшить еду так, чтобы в тарелке осталось >= 0 кусков еды, то возвращаем true, в противном случае - false).
//Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны). Если коту удалось покушать (хватило еды), сытость = true.
//Считаем, что если коту мало еды в тарелке, то он её просто не трогает, то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
//Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки и потом вывести информацию о сытости котов в консоль.
public class HomeWorkSixMain {
    public static void main(String[] args) {
        Cat[] cats = {
                new Cat("Мурзик", 5),
                new Cat("Барсик", 7),
                new Cat("Васька", 4)
        };

        // Создаем тарелку с едой
        Plate plate = new Plate(20);

        // Просим всех котов покушать
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.println("Кот " + cat.getName() + " сытость: " + (cat.isSatiety() ? "сыт" : "голоден"));
        }

        // Выводим оставшееся количество еды в тарелке
        System.out.println("Оставшееся количество еды в тарелке: " + plate.getCurrentFood());
    }
}
