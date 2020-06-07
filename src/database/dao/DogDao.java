package database.dao;

import database.dto.Dog;

import java.sql.*;
import java.util.*;

public class DogDao {

    private static DogDao instance;
    private final String jdbcUrl = "jdbc:postgresql://localhost:5432/postgres";
    private final Properties userInfo;


    private DogDao() {
        userInfo = new Properties();
        userInfo.setProperty("user", "postgres");
        userInfo.setProperty("password", "1-1Cfesd1");
    }


    public static DogDao getInstance() {
        if (instance == null) {
            instance = new DogDao();
        }
        return instance;
    }

    public void createTable() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE DOGS(id varchar(64) NOT NULL, " +
                    "name varchar(100) NOT NULL, " +
                    "age INT NOT NULL)");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void addNewDog(Dog dog) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO DOGS VALUES(?,?,?)")) {
            System.out.println(connection.toString());
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(2, dog.getName());
            statement.setInt(3, dog.getAge());
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public List<Dog> getDogsByName(String name) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM DOGS WHERE name = ?")) {
            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                List<Dog> dogs = new ArrayList<>();
                while (rs.next()) {
                    Dog dog = new Dog();
                    dog.setId(rs.getString(1));
                    dog.setName(rs.getString(2));
                    dog.setAge(rs.getInt(3));
                    dogs.add(dog);
                }
                return dogs;
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return Collections.emptyList();
    }

    public List<Dog> getAllDogs() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM DOGS")) {
            try (ResultSet rs = statement.executeQuery()) {
                List<Dog> dogs = new ArrayList<>();
                while (rs.next()) {
                    Dog dog = new Dog();
                    dog.setId(rs.getString(1));
                    dog.setName(rs.getString(2));
                    dog.setAge(rs.getInt(3));
                    dogs.add(dog);
                }
                return dogs;
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return Collections.emptyList();
    }

    public List<Dog> getDogsOlderThan(int age) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM DOGS WHERE age > ?")) {
            statement.setInt(1, age);
            try (ResultSet rs = statement.executeQuery()) {
                List<Dog> dogs = new ArrayList<>();
                while (rs.next()) {
                    Dog dog = new Dog();
                    dog.setId(rs.getString(1));
                    dog.setName(rs.getString(2));
                    dog.setAge(rs.getInt(3));
                    dogs.add(dog);
                }
                return dogs;
            }
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
        return Collections.emptyList();
    }

    public void deleteDog(String id) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("DELETE FROM DOGS WHERE id = ?")) {
            System.out.println("Please provide the Dog id to delete");
            Scanner scanner = new Scanner(System.in);
            id = scanner.nextLine().trim();
            statement.setString(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

    public void updateDogAge(String id, int age) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("UPDATE DOGS SET age = ? WHERE id = ?")) {
            System.out.println("Please provide the Dog id to update");
            Scanner scanner = new Scanner(System.in);
            id = scanner.nextLine().trim();
            System.out.println("Please provide the new Dog age");
            age = scanner.nextInt();
            statement.setString(1, id;
            statement.setInt(2, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
        }
    }

}
