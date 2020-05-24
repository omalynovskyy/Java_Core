package database;

import database.dao.DogDao;
import database.dto.Dog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DogDao instance = DogDao.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Type operation:\n add - for adding new dog\n get - get info about all dogs\n " +
                "gName - get all dogs by name\n aAge - get all dogs older than specified age\n" +
                "exit - for quit from program");
        String operation = scanner.nextLine().trim();

        switch (operation) {

        }

    }

    public static void addNewDog(Scanner scanner, DogDao dao) {
        System.out.println("Enter dog name");
        String name = scanner.nextLine().trim();
        System.out.println("Enter dog age");
        int age = scanner.nextInt();
        Dog dog = new Dog();
        dog.setName(name);
        dog.setAge(age);
        dao.addNewDog(dog);
    }

    public static void getDogByName(Scanner scanner, DogDao dao) {
        System.out.println("Enter dog name");
        String name = scanner.nextLine().trim();
        System.out.println("Enter dog age");
        int age = scanner.nextInt();
        Dog dog = new Dog();
        dog.setName(name);
        dog.setAge(age);
        dao.addNewDog(dog);
    }
}
