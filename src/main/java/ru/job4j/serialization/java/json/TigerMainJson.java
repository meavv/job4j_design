package ru.job4j.serialization.java.json;

import org.json.JSONObject;

public class TigerMainJson {
    public static void main(String[] args) {
        Tiger tiger1 = new Tiger(true, 12, "Qwe",
                new Animal("Cat"), "Russia", "China");
        Tiger tiger2 = new Tiger(true, 16, "Eewew",
                new Animal("Cat"), "Russia", "China");

        System.out.println(transform(tiger1));
        System.out.println(transform(tiger2));
    }

    private static JSONObject transform(Tiger tiger) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("striped", tiger.isStriped());
        jsonObject.put("age", tiger.getAge());
        jsonObject.put("name", tiger.getName());
        jsonObject.put("animal", tiger.getAnimal());
        jsonObject.put("habitat", tiger.getHabitat());
        return jsonObject;
    }
}