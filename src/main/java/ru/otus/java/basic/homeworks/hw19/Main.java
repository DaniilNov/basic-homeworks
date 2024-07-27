package ru.otus.java.basic.homeworks.hw19;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());
        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());
        System.out.println("Вес коробки с яблоками: " + appleBox.getWeight());
        System.out.println("Вес коробки с апельсинами: " + orangeBox.getWeight());
        System.out.println("Коробки равны по весу: " + appleBox.compare(orangeBox));
        Box<Fruit> mixedBox = new Box<>();
        appleBox.transferFruitsTo(mixedBox);
        orangeBox.transferFruitsTo(mixedBox);
        System.out.println("Вес смешанной коробки: " + mixedBox.getWeight());
    }
}
