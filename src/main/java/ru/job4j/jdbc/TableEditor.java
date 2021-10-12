package ru.job4j.jdbc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private static Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    private final Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    public static void start() {
        Properties properties = new Properties();
        try (BufferedReader b = new BufferedReader(new FileReader("data/app.properties"))) {
            properties.load(b);
            TableEditor tableEditor = new TableEditor(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(properties.get("url").toString(),
                properties.get("login").toString(), properties.get("password").toString());
    }


    public static void createTable(String tableName) throws Exception {
        start();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table %s();",
                        tableName
                );
                statement.execute(sql);
                System.out.println(getTableScheme(connection, tableName));
            }
        }
    }

    public static void dropTable(String tableName) throws Exception {
        start();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "drop table %s;",
                        tableName
                );
                statement.execute(sql);
            }
        }
    }

    public static void addColumn(String tableName, String columnName, String type) throws Exception {
        start();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "ALTER TABLE %s ADD COLUMN %s %s;",
                        tableName, columnName, type
                );
                statement.execute(sql);
            }
        }
    }

    public static void dropColumn(String tableName, String columnName) throws Exception {
        start();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "ALTER TABLE %s DROP COLUMN %s;",
                        tableName, columnName
                );
                statement.execute(sql);
            }
        }
    }

    public static void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        start();
        try (Connection connection = getConnection()) {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "ALTER TABLE %s RENAME COLUMN %s TO %s;",
                        tableName, columnName, newColumnName
                );
                statement.execute(sql);
            }
        }
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


    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}