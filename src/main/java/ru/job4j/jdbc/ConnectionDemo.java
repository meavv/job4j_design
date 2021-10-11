package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Config config = new Config("data/app.properties");
        config.load();
        String url = config.value("url");
        String login = config.value("login");
        String pass = config.value("password");
        Class.forName("org.postgresql.Driver");
        try (Connection connection = DriverManager.getConnection(url, login, pass)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}