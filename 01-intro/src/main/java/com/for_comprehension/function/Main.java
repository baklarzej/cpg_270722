package com.for_comprehension.function;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Supplier<Integer> supplier = () -> 42;
        Callable<Integer> callable = () -> 42;
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
