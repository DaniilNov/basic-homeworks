package ru.otus.java.basic.homeworks.hw20;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Введите имя файла: ");
            String fileName = scanner.nextLine();

            System.out.print("Введите искомую последовательность символов: ");
            String searchString = scanner.nextLine();

            File file = new File(fileName);
            if (!file.exists()) {
                System.err.println("Файл не найден: " + file.getAbsolutePath());
                return;
            }

            try {
                String content = readFile(fileName);
                int count = countOccurrences(content, searchString);
                System.out.println("Количество вхождений: " + count);
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
        }
    }

    private static String readFile(String fileName) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    private static int countOccurrences(String content, String searchString) {
        int count = 0;
        int index = 0;
        while ((index = content.indexOf(searchString, index)) != -1) {
            count++;
            index += searchString.length();
        }
        return count;
    }
}