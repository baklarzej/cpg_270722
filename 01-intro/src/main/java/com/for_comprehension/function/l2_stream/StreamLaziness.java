package com.for_comprehension.function.l2_stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamLaziness {

    public static void main(String[] args) {
        Arrays.asList(1, 2, 3, 4, 5).stream()
            .map(a -> {
                System.out.println("do something with " + a);
                return a;
            });

    }

    public static void terminalVsIntermediate() {
        // terminal vs intermediate methods
        IntStream.generate(() -> 42).boxed()
            .map(i -> i + 1)
            .filter(i -> true)
            .findFirst();

        Arrays.asList(1, 2, 3, 4, 5).stream()
            .peek(value -> System.out.println(value + " before map1(i -> i)"))
            .map(i -> i)
            .peek(value -> System.out.println(value + " after map1(i -> i), before filter"))
            .filter(i -> i > 1)
            .peek(value -> System.out.println(value + " after filter, before map2(i -> i)"))
            .map(i -> i)
            .peek(value -> System.out.println(value + " after map2(i -> i), before findFirst()"))
            .findFirst();
    }

}
