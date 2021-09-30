package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Qwe";
        int age = 33;
        long cash = 999999999;
        byte hand = 2;
        boolean goodBoy = true;
        float weight = 74.54987f;
        double height = 177.5;
        char sex = 'm';
        LOG.debug("name : {}, age : {}, cash : {}, hand : {}, goodBoy: {}, weight: {}, height : {}, sex: {}", name, age, cash, hand, goodBoy, weight, height, sex);
    }
}