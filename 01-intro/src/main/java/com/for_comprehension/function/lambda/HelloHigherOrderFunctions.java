package com.for_comprehension.function.lambda;

import java.util.function.Supplier;

public class HelloHigherOrderFunctions {

    public static void main(String[] args) {
        Supplier<Integer> fourtytwosupplier = getValue(42);
        Supplier<Integer> onesupplier = getValue(1);
    }


    public static Supplier<Integer> getValue(int value) {
        return () -> value;
    }
}
