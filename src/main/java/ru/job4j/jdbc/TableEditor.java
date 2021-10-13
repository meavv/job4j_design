package ru.job4j.jdbc;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private static Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        try (BufferedReader b = new BufferedReader(new FileReader("data/app.properties"))) {
            properties.load(b);
            Class.forName(properties.get("driver").toString());
            connection = DriverManager.getConnection(properties.get("url").toString(),
                    properties.get("login").toString(), properties.get("password").toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void executePro(String format) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(format);
        }
    }

    public void createTable(String tableName) throws Exception {
        executePro(String.format("create table %s();", tableName));
    }

    public void dropTable(String tableName) throws Exception {
        executePro(String.format("drop table %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        executePro(String.format("ALTER TABLE %s ADD COLUMN %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        executePro(String.format("ALTER TABLE %s DROP COLUMN %s;", tableName, columnName));

    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        executePro(String.format("ALTER TABLE %s RENAME COLUMN %s TO %s;",
                tableName, columnName, newColumnName));
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