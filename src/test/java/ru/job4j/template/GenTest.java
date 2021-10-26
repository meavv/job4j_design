package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class GenTest {

    @Ignore
    @Test
    public void produce() {
        Generator generator = new Gen();
        String s = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = Map.of("name", "Qwe", "subject", "you");
        assertEquals(generator.produce(s, map), "I am a Qwe, Who are you? ");
    }

    @Ignore
    @Test(expected = Exception.class)
    public void produceException() {
        Generator generator = new Gen();
        String s = "I am a ${name}, Who are ${subt}? ";
        Map<String, String> map = Map.of("name", "Qwe", "subject", "you");
        assertEquals(generator.produce(s, map), "I am a Qwe, Who are you? ");
    }

    @Ignore
    @Test(expected = Exception.class)
    public void produceException2() {
        Generator generator = new Gen();
        String s = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> map = Map.of("name", "Qwe", "subject", "you", "www", "WWW");
        assertEquals(generator.produce(s, map), "I am a Qwe, Who are you? ");
    }
}