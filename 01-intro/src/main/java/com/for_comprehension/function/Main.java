package com.for_comprehension.function;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;

/**
 *
 */
public class Main {

    public static void main(String[] args) {

        Map<Integer, String> result = Stream.of("a", "b", "cc", "dd", "eeee")
            .collect(groupingBy(String::length, joining(",")));

        System.out.println(result);

    }

    public static int run(Supplier<Integer> run) {
        if (LocalDate.now().getDayOfWeek() == DayOfWeek.MONDAY) {
            return run.get();
        }

        return 42;
    }

    public static long calculate() {
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Instant.now().toEpochMilli();
    }

}
