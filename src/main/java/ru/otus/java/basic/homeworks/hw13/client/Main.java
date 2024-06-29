package ru.otus.java.basic.homeworks.hw13.client;

import java.net.Socket;
import java.util.Scanner;

/**
 * Сервер: выполняет математические вычисления: +,-,*,/
 * Клиент-серверное взаимодействие:
 * <p>
 * клиент подключается к серверу, получает строку с доступными мат. операциями. Отображает ее пользователю.
 * пользователь вводит два числа и команду в консоль
 * отправляется запрос на сервер, сервер выполняет вычисления, возвращает результат клиенту.
 * клиент отображает результат в консоль
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Доступные мат. операции: +-/*");
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();
        try (Socket socket = new Socket("localhost", 8888)) {
            PingClient pingClient = new PingClient(socket);
            System.out.println();
            pingClient.send(userInput + "\n");
            String result = pingClient.read();
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
