package ru.otus.java.basic.homeworks.hw4;

public class Box {
    // Размеры коробки
    private final int length;
    private final int width;
    private final int height;

    // Цвет коробки
    private String color;

    // Состояние коробки - открыта или закрыта
    private boolean isOpen;

    // Предмет в коробке
    private String item;

    public Box(int length, int width, int height, String color) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.color = color;
        this.isOpen = false; // Коробка изначально закрыта
        this.item = null; // Изначально в коробке нет предмета
    }

    // Метод для открытия коробки
    public void open() {
        if (!isOpen) {
            isOpen = true;
            System.out.println("Коробка открыта.");
        } else {
            System.out.println("Коробка уже открыта.");
        }
    }

    // Метод для закрытия коробки
    public void close() {
        if (isOpen) {
            isOpen = false;
            System.out.println("Коробка закрыта.");
        } else {
            System.out.println("Коробка уже закрыта.");
        }
    }

    // Метод для перекрашивания коробки
    public void repaint(String newColor) {
        this.color = newColor;
        System.out.println("Коробка перекрашена в цвет: " + newColor);
    }

    // Метод для добавления предмета в коробку
    public void putItem(String newItem) {
        if (isOpen) {
            if (item == null) {
                item = newItem;
                System.out.println("Предмет '" + newItem + "' добавлен в коробку.");
            } else {
                System.out.println("Коробка уже содержит предмет.");
            }
        } else {
            System.out.println("Коробка закрыта. Откройте коробку, чтобы добавить предмет.");
        }
    }

    // Метод для извлечения предмета из коробки
    public void removeItem() {
        if (isOpen) {
            if (item != null) {
                System.out.println("Предмет '" + item + "' извлечен из коробки.");
                item = null;
            } else {
                System.out.println("Коробка пуста.");
            }
        } else {
            System.out.println("Коробка закрыта. Откройте коробку, чтобы извлечь предмет.");
        }
    }

    // Метод для печати информации о коробке
    public void printInfo() {
        System.out.println("Коробка: " + length + "x" + width + "x" + height + ", цвет: " + color +
                ", " + (isOpen ? "открыта" : "закрыта") +
                ", содержит предмет: " + (item != null ? item : "нет"));
    }
}