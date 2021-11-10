package ru.job4j.ood.isp;

public class Actions implements Action {

    @Override
    public Action action(String nodeName) {
        Action action = new Actions();
        System.out.println("Выбран пункт : " + nodeName);
        return action;
    }
}
