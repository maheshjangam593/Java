package main.java.util;

import main.java.util.internal.AddHelper;

public class Calculator {

    AddHelper helper=new AddHelper();
    public int add(int i, int j) {

        return helper.add(i,j);

    }
}
