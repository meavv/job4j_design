package ru.job4j.it;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int row = 0; int column = 0;
        int[][] in = {
                {}, {1}
        };
        boolean check = in[row].length == 0;
        System.out.println(in[0].length);
        System.out.println(check);
        System.out.println(Arrays.toString(in[0]));
    }
}
