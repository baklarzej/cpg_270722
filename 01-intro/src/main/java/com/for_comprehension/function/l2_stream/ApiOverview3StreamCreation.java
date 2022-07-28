package com.for_comprehension.function.l2_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ApiOverview3StreamCreation {

    public static void main(String[] args) {
        Stream.generate(() -> 42); // infinite stream of 42
        Stream.iterate(0, i -> i + 1);
        Stream.iterate(0, i -> i < 10, i -> i + 1);
        Stream.concat(Stream.of(1), Stream.of(2));
        Stream.ofNullable(null);

        IntStream.range(0, 10);
        IntStream.rangeClosed(0, 10);
    }

}
