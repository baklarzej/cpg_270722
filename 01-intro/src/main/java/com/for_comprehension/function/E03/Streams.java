package com.for_comprehension.function.E03;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

class Streams {

    private static void L0_cubeComposer() {
        // https://david-peter.de/cube-composer/
    }

    /**
     * Uppercase all strings in a list {@link Stream#map(Function)}
     */
    static Function<List<String>, List<String>> L1_upperCaseAll() {
        return input -> {
            throw new RuntimeException("TODO");
        };
    }

    /**
     * Uppercase all list elements and discard names containing less than 6 characters
     * {@link Stream#filter(Predicate)}
     */
    static Function<List<String>, List<String>> L2_upperCaseAllAndFilter() {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Find the longest name {@link Stream#max(Comparator)} {@link Stream#sorted()} {@link Stream#findAny()}
     */
    static Function<List<String>, String> L3_findTheLongestName() {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Flatten a nested list structure {@link Stream#flatMap(Function)}
     */
    static Function<List<List<Integer>>, List<Integer>> L4_flatten() {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Eliminate duplicates {@link Stream#distinct()}
     */
    static Function<List<Integer>, List<Integer>> L5_distinctElements() {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Duplicate the elements of a list
     */
    static Function<List<Integer>, List<Integer>> L6_duplicateElements() {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Duplicate the elements of a list a given number of times {@link Stream#generate(Supplier)}
     */
    static Function<List<Integer>, List<Integer>> L7_duplicateElementsNTimes(int givenNumberOfTimes) {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Create a stream only with multiples of 3, starting from 0, size of 10 {@link Stream#iterate}
     */
    static Supplier<List<Integer>> L8_generate3s() {
        return () -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Find five consecutive leap years since 2000 {@link Stream#iterate(Object, UnaryOperator)}
     * {@link LocalDate#isLeapYear()}
     */
    static Supplier<List<Integer>> L9_leapYears() {
        return () -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Rotate a list N places to the left {@link Stream#concat(Stream, Stream)} {@link Stream#skip(long)}
     * {@link Stream#limit(long)}
     */
    static UnaryOperator<List<Integer>> L10_rotate(int n) {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Check if all elements sum up to 100, if no throw an exception
     */
    static Predicate<List<Double>> L11_sum() throws IllegalStateException {
        return input -> {
            throw new RuntimeException("TODO");

        };
    }

    /**
     * Convert a {@link List} of {@link Optional} to a {@link List} of only not-empty values
     *
     * Advanced challenge: use {@link Stream#flatMap(Function)}
     */
    static Function<List<Optional<Integer>>, List<Integer>> L12_filterPresent() {
        return list -> {
            throw new RuntimeException("TODO");

        };
    }

}
