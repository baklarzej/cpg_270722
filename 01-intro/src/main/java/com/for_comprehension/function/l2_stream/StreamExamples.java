package com.for_comprehension.function.l2_stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        IntStream.range(0, 10).boxed()
            .peek(System.out::println)
            .count();


    }

    public static void shortcircuit() {
        // stream shortcircuit
        Arrays.asList(1, 2, 3).stream()
            .peek(a -> System.out.println("before " + a))
            .map(i -> {

                System.out.println("sending email");
                if (i == 777) {
                    throw new RuntimeException();
                }
                return i;
            })
            .peek(a -> System.out.println("after " + a))
            .count();
    }

    public static void streamVsOptional() {
        Stream.of(2)
            .filter(i -> i % 2 == 0)
            .map(i -> i + 1)
            .forEach(System.out::println);

        Optional.of(2)
            .filter(i -> i % 2 == 0)
            .map(i -> i + 1)
            .ifPresent(System.out::println);
    }

}
