package com.for_comprehension.function;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        var defaultValue = 42L;

        var r = Optional.of(1L)
            .orElse(defaultValue);
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
