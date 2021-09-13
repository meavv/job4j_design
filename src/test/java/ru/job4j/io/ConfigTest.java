package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        Config config = new Config("data/pair_without_comment.properties");
        config.load();
        assertThat(config.value("name"),is("Qwe"));
    }

    @Test
    public void whenEmptyAndCommitString() {
        Config config = new Config("data/emptyString");
        config.load();
        assertThat(config.value("name"),is("Qwe"));
    }

    @Test
    public void PostgreSQL() {
        Config config = new Config("app.properties");
        config.load();
        assertThat(config.value("hibernate.dialect"),is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.driver_class"),is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"),is("postgres"));
        assertThat(config.value("hibernate.connection.password"),is("password"));
    }


    @Test(expected = IllegalArgumentException.class)
    public void whenWrongPattern() {
        String path = "data/IllegalArgumentException";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("hibernate.connection.driver_class"), isEmptyString());
    }
}