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

    public void createTabla() {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             Statement statement = connection.createStatement()) {
            statement.execute("CREATE TABLE DOGS(id varchar(64) NOT NULL, " +
                    "name varchar(100) NOT NULL, " +
                    "age INT NOT NULL)");
        } catch (SQLException e) {
            System.out.println(e.getErrorCode());
            List

        }
    }

    public void addNewDog(Dog dog) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("INSERT INTO DOGS VALUES(?,?,?)")) {
            statement.setString(1, UUID.randomUUID().toString());
            statement.setString(1, dog.getName());
            statement.setInt(1, dog.getAge());
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

    public List<Dog> getDogsOlderThan(int age) {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, userInfo);
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM DOGS WHERE age > ?")) {
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

}
