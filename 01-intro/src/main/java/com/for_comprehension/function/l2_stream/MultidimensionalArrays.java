package com.for_comprehension.function.l2_stream;

import java.util.Arrays;

public class MultidimensionalArrays {

    public static void main(String[] args) {
        // 1
        // 2, 3
        Integer[][] integers = {new Integer[]{1}, new Integer[]{2, 3}};

        Arrays.stream(integers)
            .map(i -> Arrays.stream(i))
            .forEach(str -> str.forEach(System.out::println));
    }

}
