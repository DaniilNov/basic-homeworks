package ru.otus.java.basic.homeworks.hw12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Реализуйте приложение, позволяющее работать с текстовыми файлами
 * При старте приложения, в консоль выводится список текстовых файлов из корневого каталоге проекта
 * Далее программа запрашивает имя файла, с которым хочет работать пользователь
 * Содержимое файла выводится в консоль
 * Затем любую введенную пользователем строку необходимо записывать в указанный файл
 */
public class TextFileApp {
    private static final String ROOT_DIR = "src/main/java/ru/otus/java/basic/homeworks/hw12";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Шаг 1: Вывод списка текстовых файлов из корневого каталога проекта
        List<Path> textFiles = listTextFiles();
        if (textFiles.isEmpty()) {
            System.out.println("Нет текстовых файлов в корневом каталоге проекта.");
            return;
        }

        System.out.println("Список текстовых файлов в корневом каталоге проекта:");
        textFiles.forEach(file -> System.out.println(file.getFileName()));

        // Шаг 2: Запрос имени файла у пользователя
        System.out.print("Введите имя файла, с которым хотите работать: ");
        String fileName = scanner.nextLine();
        Path filePath = Paths.get(ROOT_DIR, fileName);

        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            System.out.println("Файл не найден или не является текстовым файлом.");
            return;
        }

        // Шаг 3: Вывод содержимого файла в консоль
        try {
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("Содержимое файла:");
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
            return;
        }

        // Шаг 4: Запись введенной пользователем строки в указанный файл
        System.out.println("Введите строку для записи в файл (или 'exit' для выхода):");
        while (true) {
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }
            try {
                Files.write(filePath, (input + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
                System.out.println("Строка записана в файл.");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }

    private static List<Path> listTextFiles() {
        try (Stream<Path> stream = Files.walk(Paths.get(TextFileApp.ROOT_DIR), 1)) {
            return stream
                    .filter(file -> !Files.isDirectory(file))
                    .filter(file -> file.toString().endsWith(".txt"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Ошибка при получении списка файлов: " + e.getMessage());
            return List.of();
        }
    }
}
