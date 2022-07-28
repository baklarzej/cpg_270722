package com.for_comprehension.function;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        IntStream intStream = IntStream.of(1);
        Stream<Integer> boxed = intStream.boxed();
        IntStream intStream1 = boxed.mapToInt(i -> i);
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
