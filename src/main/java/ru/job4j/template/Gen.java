package ru.job4j.template;

import ru.job4j.serialization.java.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Gen implements Generator {

    @Override
    public String produce(String template, Map<String, String> args) throws Exception {
        var list = Arrays.stream(template.split(" "))
                .filter(a -> a.contains("${"))
                .map(a -> a.replaceAll("\\$|\\{|}|,|\\?", ""))
                .collect(Collectors.toList());
        String rsl = template.replaceAll("\\$|\\{|}", "");
        if (args.size() != list.size()) {
            throw new Exception();
        }
        for (String s : list) {
            rsl = rsl.replace(s, args.get(s));
        }
        return rsl;
    }

    public static void main(String[] args) throws Exception {
        Map<String, String> map = Map.of("name", "Qwe", "subject", "you");
        Generator g = new Gen();
        String template = "I am a ${name}, Who are ${subject}?";
        var x = g.produce(template, map);
        System.out.println(x);
    }
}