package ru.job4j.collection.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        Map<Object, Object> previousMap = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        for (User u : current) {
            if (!previousMap.containsKey(u.getId())) {
                added++;
            } else {
                if (!previousMap.get(u.getId()).equals(u.getName())) {
                    changed++;
                }
            }
        }
        return new Info(added, changed,
                Math.abs(Math.abs(previous.size() - current.size()) - added));
    }
}