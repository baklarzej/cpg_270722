package com.for_comprehension.function.l3_execute_around;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class ExecuteAroundExecutionTimeLogging {

    public static void main(String[] args) {
        withLogging(withTiming(() -> compute())).get();

        System.out.println("-----");

        timed(() -> compute());
    }

    public static <T> Supplier<T> withLogging(Supplier<T> runnable) {
        return () -> {
            System.out.println("Entering method");
            T result = runnable.get();
            System.out.println("Exiting method");
            return result;
        };
    }

    public static <T> Supplier<T> withTiming(Supplier<T> function) {
        return () -> {
            var before = Instant.now();
            T result = function.get();
            var after = Instant.now();

            long millis = Duration.between(before, after).toMillis();

            System.out.println("Took: " + millis + "ms");

            return result;
        };
    }

    public static <T> T timed(Supplier<T> function) {
        var before = Instant.now();
        T result = function.get();
        var after = Instant.now();

        long millis = Duration.between(before, after).toMillis();

        System.out.println("Took: " + millis + "ms");

        return result;
    }

    public static String compute() {
        System.out.println("calculating...");
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
        }
        System.out.println("finished");
        return "42";
    }

}
