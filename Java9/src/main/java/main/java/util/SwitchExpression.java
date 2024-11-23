package main.java.util;

import java.util.List;

public class SwitchExpression {
    public static void main(String[] args) {

        List<Integer> integers = List.of(1, 2, 3);
        integers.add(12);
        System.out.println(integers);


        String str="sun";
        String time="";
        time=switch(str) {
            case "sun"-> "6AM";
            case "mon" -> "10AM";
            default -> "8AM";
        };
        System.out.println(time);
    }
}

