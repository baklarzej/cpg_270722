package com.for_comprehension.function.E03;

import java.time.LocalDate;
import java.time.Year;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

class Streams {

    private static void L0_cubeComposer() {
        // https://david-peter.de/cube-composer/
    }

    /**
     * Uppercase all strings in a list {@link Stream#map(Function)}
     */
    static Function<List<String>, List<String>> L1_upperCaseAll() {
        return input -> input.stream()
            .map(String::toUpperCase)
            .collect(toList());
    }

    /**
     * Uppercase all list elements and discard names containing less than 6 characters
     * {@link Stream#filter(Predicate)}
     */
    static Function<List<String>, List<String>> L2_upperCaseAllAndFilter() {
        return input -> input.stream()
            .filter(s -> s.length() > 6)
            .map(String::toUpperCase)
            .collect(toList());
    }

    /**
     * Find the longest name {@link Stream#max(Comparator)} {@link Stream#sorted()} {@link Stream#findAny()}
     */
    static Function<List<String>, String> L3_findTheLongestName() {
        return input -> input.stream()
            .max(Comparator.comparing(String::length))
            .orElseThrow();
    }

    /**
     * Flatten a nested list structure {@link Stream#flatMap(Function)}
     *
     * [[1], [2,3], []] -> [1, 2, 3]
     */

    static Function<List<List<Integer>>, List<Integer>> L4_flatten() {
        return input -> input.stream()
            .flatMap(Collection::stream)
            .collect(toList());
    }

    /**
     * Eliminate duplicates {@link Stream#distinct()}
     */
    static Function<List<Integer>, List<Integer>> L5_distinctElements() {
        return input -> input.stream().distinct().collect(toList());
    }

    /**
     * Duplicate the elements of a list
     */
    static Function<List<Integer>, List<Integer>> L6_duplicateElements() {
        return input -> {
            return input.stream()
                // .flatMap(value -> Stream.concat(Stream.of(value), Stream.of(value)))
                .flatMap(v -> Stream.of(v, v))
                .collect(toList());
        };
    }

    /**
     * Duplicate the elements of a list a given number of times {@link Stream#generate(Supplier)}
     */
    static Function<List<Integer>, List<Integer>> L7_duplicateElementsNTimes(int givenNumberOfTimes) {
        return input -> input.stream()
            .flatMap(value -> Stream.generate(() -> value).limit(givenNumberOfTimes))
            /*.flatMap(value -> {
                Stream<Integer> accumulator = Stream.empty();
                for (int i = 0; i < givenNumberOfTimes; i++) {
                    accumulator = Stream.concat(accumulator, Stream.of(value));
                }
                return accumulator;
            })*/
            .collect(toList());
    }

    /**
     * Create a stream only with multiples of 3, starting from 0, size of 10 {@link Stream#iterate}
     */
    static Supplier<List<Integer>> L8_generate3s() {
        return () -> IntStream.range(0, 10).mapToObj(i -> i * 3).collect(toList());
//        return () -> Stream.iterate(0, i -> i + 3).limit(10).collect(toList());
    }

    /**
     * Find five consecutive leap years since 2000 {@link Stream#iterate(Object, UnaryOperator)}
     * {@link LocalDate#isLeapYear()}
     */
    static Supplier<List<Integer>> L9_leapYears() {
        return () -> {
            return Stream.iterate(200, year -> year + 1)
                .filter(Year::isLeap)
                .limit(5)
                .collect(toList());
            /*return Stream.iterate(Year.of(2000), year -> year.plusYears(1))
                .filter(Year::isLeap)
                .limit(5)
                .map(Year::getValue)
                .collect(toList());*/

        };
    }

    /**
     * Rotate a list N places to the left {@link Stream#concat(Stream, Stream)} {@link Stream#skip(long)}
     * {@link Stream#limit(long)}
     *
     * [1,2,3,4] -> [2,3,4,1] -> [3,4,1,2] -> [4,1,2,3] -> [1,2,3,4]
     * [1,2,3,4][1,2,3,4]
     */
    static UnaryOperator<List<Integer>> L10_rotate(int n) {
        return input -> Stream.concat(input.stream(), input.stream())
            .skip(n % input.size())
            .limit(input.size())
            .collect(toList());
    }

    /**
     * Check if all elements sum up to 100, if no throw an exception
     */
    static Predicate<List<Double>> L11_sum() throws IllegalStateException {

        return input -> {
            return input.stream()
                .reduce(Double::sum)
                .map(sum -> sum == 100)
                .filter(i -> i)
                .orElseThrow(IllegalStateException::new);

/*            double sum = input.stream()
                .mapToDouble(i -> i)
                .sum();

            if (sum != 100) {
                throw new IllegalArgumentException();
            }

            return true;*/

        };
    }

    /**
     * Convert a {@link List} of {@link Optional} to a {@link List} of only not-empty values
     *
     * Advanced challenge: use {@link Stream#flatMap(Function)}
     *
     * [Optional(1), Optional(2), Optional()] -> [1,2]
     */
    static Function<List<Optional<Integer>>, List<Integer>> L12_filterPresent() {
        return list -> {
            return list.stream()
                .flatMap(Optional::stream)
                .collect(toList());

//
//            return list.stream()
//                .flatMap(o -> o.map(Stream::of).orElseGet(Stream::empty))
//                .collect(toList());
//
            /*
            return list.stream()
                .flatMap(o -> o.isPresent() ? Stream.of(o.get()) : Stream.empty())
                .collect(toList());
            */

            /*
            return list.stream()
                .filter(Optional::isPresent)
                .map(Optional::orElseThrow)
                .collect(toList());
            */
        };
    }

}
