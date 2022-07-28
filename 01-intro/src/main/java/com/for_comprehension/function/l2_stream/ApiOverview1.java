package com.for_comprehension.function.l2_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class ApiOverview1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3);

        // print all stream elements
        list.stream()
            .map(i -> i + 1)
            .forEach(System.out::println);

        // find first element of a stream
        Optional<Integer> first = list.stream()
            .map(i -> i + 1)
            // .findAny() // no ordering guarantees
            .findFirst();// ordering guarantees

        // count all stream elements
        long count = list.stream()
            .map(i -> i + 1)
            .count();

        // reduce all stream elements to a single element
        Optional<Integer> reduce = list.stream()
            .map(i -> i + 1)
            .reduce((i1, i2) -> i1 + i2);

        Integer reduce2 = list.stream()
            .map(i -> i + 1)
            .reduce(0, (i1, i2) -> i1 + i2);

        // find max/min of a stream
        Optional<Integer> max = list.stream()
            .map(i -> i + 1)
            .max(Comparator.naturalOrder());

        Optional<String> max2 = Stream.of("a", "bb", "CCC")
            .max(comparing(String::length));

        // sort stream elements
        list.stream()
            .sorted()
            .forEach(System.out::println);

        // non repeating elements
        list.stream()
            .map(i -> i)
            .distinct()
            .forEach(System.out::println);

        // skip first/last elements
        list.stream()
            .map(i -> i)
            .skip(3)
            .limit(10);

        list.stream()
            .takeWhile(i -> i > 10)
            .dropWhile(i -> i > 10);

        // check if elements match conditions
        boolean b = list.stream().allMatch(i -> i > 0);
        boolean b1 = list.stream().noneMatch(i -> i > 0);
        boolean b2 = list.stream().anyMatch(i -> i > 0);

    }

}
