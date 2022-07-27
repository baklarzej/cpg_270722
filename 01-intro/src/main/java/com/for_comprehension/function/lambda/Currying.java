package com.for_comprehension.function.lambda;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Currying {

    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> f1 = (i1, i2) -> i1 + i2;

        Function<Integer, Function<Integer, Integer>> f1_curried = i1 -> i2 -> i1 + i2;

        Function<Integer, Integer> add42 = f1_curried.apply(42);
        Function<Integer, Integer> add2 = f1_curried.apply(22);

    }
}
