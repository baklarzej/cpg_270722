package com.for_comprehension.function.l2_stream;

import java.util.IntSummaryStatistics;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class ApiOverview2PrimitiveStreams {

    public static void main(String[] args) {

        OptionalInt max = Stream.of(1)
            .mapToInt(i -> i)
            .max();

        OptionalInt min = Stream.of(1)
            .mapToInt(i -> i)
            .min();

        int sum = Stream.of(1)
            .mapToInt(i -> i)
            .sum();

        IntSummaryStatistics intSummaryStatistics = Stream.of(1)
            .mapToInt(i -> i)
            .summaryStatistics();

        Stream<Integer> boxed = IntStream.of(1)
            .boxed();
    }

}
