package ru.otus.java.basic.homeworks.hw4;

public class User {
    private String firstName;
    private String lastName;
    private String middleName;
    private int yearOfBirth;
    private String email;

    public User(String firstName, String lastName, String middleName, int yearOfBirth, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.yearOfBirth = yearOfBirth;
        this.email = email;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void userInfo() {
        System.out.println("ФИО: " + this.lastName + " " + this.firstName + " " + this.middleName
                + "\nГод рождения: " + this.yearOfBirth
                + "\ne - mail: " + this.email);
    }

}
