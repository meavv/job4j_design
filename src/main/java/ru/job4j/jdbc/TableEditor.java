package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    public static void main(String[] args) {
        try (BufferedReader b = (new BufferedReader(new FileReader("data/app.properties")))) {
            Properties properties = new Properties();
            properties.load(b);
            System.out.println(properties.get("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initConnection() {
        connection = null;
    }

    public void createTable(String tableName)  {
        try (BufferedReader b = (new BufferedReader(new FileReader("data/app.properties")))) {
            properties.load(b);
            System.out.println(properties.get("url"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void dropTable(String tableName) {
    }

    public void addColumn(String tableName, String columnName, String type) {
    }

    public void dropColumn(String tableName, String columnName) {
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) {
    }


    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    private static Connection getConnection() throws Exception {
        Config config = new Config("data/app.properties");
        config.load();
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(config.value("url"), config.value("login"), config.value("password"));
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}