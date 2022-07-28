package com.for_comprehension.function.l0_lambda;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class HelloLambda {

    /*
            (String a, String b) -> {
                return 42;
            }
            ----
            (a, b) -> {
                return 42;
            }
            ----
            (a, b) -> 42
            ----
            ----
            () -> 42
            ----
            a -> 42
            ----
            a -> {}
     */
    public static void main(String[] args) {

        Function<Integer, String> f1 = i -> i.toString();
        BiFunction<Integer, Integer, String> f2 = (i1, i2) -> (i1 + i2) + "";
        Supplier<Integer> f3 = () -> 42;                                      // Function<Void, T>
        Consumer<Integer> f4 = value -> System.out.println(value);            // Function<T, Void>
        Predicate<Integer> f5 = value -> value % 2 == 1;                      // Function<T, Boolean>
        Runnable f6 = () -> {
            System.out.println("foo");
        };                   // Function<Void, Void
        UnaryOperator<Integer> f7 = i -> i + 1;                               // Function<T,T>
        BinaryOperator<Integer> f8 = (i1, i2) -> Integer.max(i1, i2);         // BiFunction<T,T,T>

        TriFunction<Integer, Integer, Integer, String> f9 = (i1, i2, i3) -> i1 + i2 + i3 + "";

        Stream.of(1, 2, 3)
                .reduce(Integer::sum);
        // .reduce((i1, i2) -> Integer.sum(i1, i2));

        Function<Integer, String> fs1 = i -> i.toString();
        Function<String, Integer> fs2 = i -> Integer.valueOf(i);

        Function<Integer, Integer> result = fs2.compose(fs1);

    }

    @FunctionalInterface
    public interface TriFunction<T1, T2, T3, R> {
        R apply(T1 t1, T2 t2, T3 t3);

        default void print() {
            System.out.println("Default methods don't violate functional interface restrictions");
        }
    }

}
