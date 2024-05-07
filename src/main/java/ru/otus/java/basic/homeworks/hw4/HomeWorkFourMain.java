package ru.otus.java.basic.homeworks.hw4;

import java.time.Year;

public class HomeWorkFourMain {
    public static void main(String[] args) {
        User[] users = {
                new User("Иван", "Иванов", "Иванович", 1977, "mail.ru"),
                new User("NameUser2", "LastNameUser2", "MiddleNameUser2", 2000, "User2@mail.ru"),
                new User("NameUser3", "LastNameUser3", "MiddleNameUser3", 1999, "User1@mail.ru"),
                new User("NameUser4", "LastNameUser4", "MiddleNameUser4", 1985, "User1@mail.ru"),
                new User("NameUser5", "LastNameUser5", "MiddleNameUser5", 1980, "User1@mail.ru"),
                new User("NameUser6", "LastNameUser6", "MiddleNameUser6", 1970, "User1@mail.ru"),
                new User("NameUser7", "LastNameUser7", "MiddleNameUser7", 2005, "User1@mail.ru"),
                new User("NameUser8", "LastNameUser8", "MiddleNameUser8", 2003, "User1@mail.ru"),
                new User("NameUser9", "LastNameUser9", "MiddleNameUser9", 2001, "User1@mail.ru"),
        };

        //В методе main() Main класса создайте массив из 10 пользователей и заполните его объектами
        // и с помощью цикла выведите информацию только о пользователях старше 40 лет.
        printUsersOlderThan40(users);

        //Попробуйте реализовать класс по его описания:
        // объекты класса Коробка должны иметь размеры и цвет.
        // Коробку можно открывать и закрывать. Коробку можно перекрашивать.
        // Изменить размер коробки после создания нельзя.
        // У коробки должен быть метод, печатающий информацию о ней в консоль.
        // В коробку можно складывать предмет (если в ней нет предмета),
        // или выкидывать его оттуда (только если предмет в ней есть), только при условии что коробка открыта
        // (предметом читаем просто строку). Выполнение методов должно сопровождаться выводом сообщений в консоль.
        Box box = new Box(10, 20, 30, "красный");
        box.printInfo(); // Вывод информации о коробке
        box.open(); // Открытие коробки
        box.putItem("Книга"); // Добавление предмета
        box.printInfo(); // Вывод информации о коробке
        box.close(); // Закрытие коробки
        box.open(); // Снова открытие коробки
        box.removeItem(); // Удаление предмета
        box.repaint("синий"); // Перекрашивание коробки
        box.printInfo(); // Вывод информации о коробке
    }


    public static void printUsersOlderThan40(User[] users) {
        int currentYear = Year.now().getValue();
        for (User user : users) {
            if (currentYear - user.getYearOfBirth() > 40) {
                user.userInfo();
            }
        }

    }
}
