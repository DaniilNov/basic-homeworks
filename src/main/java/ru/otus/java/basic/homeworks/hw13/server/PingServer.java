package ru.otus.java.basic.homeworks.hw13.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PingServer {

    private static final Pattern MATH_EXPRESSION_PATTERN = Pattern.compile("^\\d+(\\.\\d+)?([+\\-*/]\\d+(\\.\\d+)?)*$");
    private static final String AVAILABLE_OPERATIONS = "Доступные мат. операции: +-/*";

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(8888)) {
            while (true) {
                try (Socket client = serverSocket.accept()) {
                    System.out.println("Client connected");
                    processRequest(client);
                } catch (IOException e) {
                    System.err.println("Error processing client request: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Could not start server: " + e.getMessage());
        }
    }

    public static void processRequest(Socket client) {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                DataOutputStream out = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()))
        ) {
            out.writeUTF(AVAILABLE_OPERATIONS);
            out.flush();

            String userInput = in.readLine();
            System.out.println("Original: " + userInput);
            String result;
            if (isValidMathExpression(userInput)) {
                result = evaluateExpression(userInput);
            } else {
                result = "Вы ввели недопустимые значения";
            }

            System.out.println("Result: " + result);
            out.writeUTF(result);
            out.flush();
        } catch (IOException e) {
            System.err.println("Error processing request: " + e.getMessage());
        }
    }

    private static boolean isValidMathExpression(String input) {
        return MATH_EXPRESSION_PATTERN.matcher(input).matches();
    }

    private static String evaluateExpression(String userInput) {
        if (userInput.contains("+")) {
            return getSum(userInput);
        } else if (userInput.contains("-")) {
            return getDifference(userInput);
        } else if (userInput.contains("*")) {
            return getProduct(userInput);
        } else if (userInput.contains("/")) {
            return getQuotient(userInput);
        } else {
            return "Invalid operation";
        }
    }

    private static String getSum(String userInput) {
        int sum = 0;
        Matcher matcher = Pattern.compile("\\d+").matcher(userInput);
        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }
        return String.valueOf(sum);
    }

    private static String getDifference(String userInput) {
        Matcher matcher = Pattern.compile("\\d+").matcher(userInput);
        int difference = 0;
        if (matcher.find()) {
            difference = Integer.parseInt(matcher.group());
        }
        while (matcher.find()) {
            difference -= Integer.parseInt(matcher.group());
        }
        return String.valueOf(difference);
    }

    private static String getProduct(String userInput) {
        int product = 1;
        Matcher matcher = Pattern.compile("\\d+").matcher(userInput);
        while (matcher.find()) {
            product *= Integer.parseInt(matcher.group());
        }
        return String.valueOf(product);
    }

    private static String getQuotient(String userInput) {
        Matcher matcher = Pattern.compile("\\d+").matcher(userInput);
        int quotient = 0;
        boolean firstNumber = true;
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if (firstNumber) {
                quotient = number;
                firstNumber = false;
            } else {
                if (number != 0) {
                    quotient /= number;
                } else {
                    return "Error: Division by zero";
                }
            }
        }
        return String.valueOf(quotient);
    }
}
