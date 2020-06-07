package database;

import database.dao.DogDao;
import database.dto.Dog;

import java.lang.reflect.AnnotatedArrayType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        DogDao dogDao = DogDao.getInstance();
        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Type operation:\n create - to create a dog table\n add - for adding new dog\n get - get info about all dogs\n " +
                    "gName - get all dogs by name\n gAge - get all dogs older than specified age\n" +
                    "exit - for quit from program");
            String operation = scanner.nextLine().trim();

            switch (operation) {
                case "create":
                    dogDao.createTable();
                    break;
                case "add":
                    addNewDog(scanner, dogDao);
                    break;
                case "gName":
                    getDogByName(scanner,dogDao);
                    break;
                case "get":

                case "exit":
                    System.exit(0);
                default:
                    System.out.println("Invalid operation");
            }

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
        List<Dog> dogs = dao.getDogsByName(name);
        String collect = dogs.stream()
                .map(Dog::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }

    public static void getAllDogs(DogDao dao) {

        List<Dog> dogs = dao.getAllDogs();
        String collect = dogs.stream()
                .map(Dog::toString)
                .collect(Collectors.joining("\n"));
        System.out.println(collect);
    }
}
