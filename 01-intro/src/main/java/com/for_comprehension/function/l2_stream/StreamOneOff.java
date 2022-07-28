package com.for_comprehension.function.l2_stream;

import java.util.stream.Stream;

public class StreamOneOff {

    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1);

        integerStream.forEach(System.out::println);
        integerStream.forEach(System.out::println);
    }
}
