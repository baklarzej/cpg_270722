package com.for_comprehension.function.l2_stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.partitioningBy;
import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toMap;

public class ApiOverview4Collect {

    public static void main(String[] args) {
        List<Integer> list = Stream.of(1, 2, 3)
            .map(i -> i + 1)
            .collect(Collectors.toList());

        Set<Integer> set = Stream.of(1, 2, 3)
            .map(i -> i + 1)
            .collect(Collectors.toSet());

        LinkedList<Integer> llist = Stream.of(1, 2, 3)
            .map(i -> i + 1)
            .collect(toCollection(LinkedList::new));

        TreeMap<String, Integer> collect = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(toMap(s -> s, String::length, (o, o2) -> o, TreeMap::new));

        Map<Integer, List<String>> groupingBy = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(groupingBy(String::length));

        TreeMap<Integer, Long> groupingByCounting = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(groupingBy(String::length, TreeMap::new, Collectors.counting()));

        Map<String, Boolean> collect2 = Stream.of("a", "aa", "bb", "ccc")
            .collect(toMap(s -> s, s -> s.length() > 2));

        Map<Boolean, List<String>> collect1 = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(partitioningBy(s -> s.length() > 2));

        // anti example
        Map<Integer, List<String>> collect3 = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(toMap(String::length, List::of, (o, o2) -> Stream.concat(o.stream(), o2.stream()).collect(Collectors.toList())));

        String joined = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(Collectors.joining(",", "{", "}"));

        String joinedUpper = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(collectingAndThen(joining(), String::toUpperCase));

        List<String> collect4 = Stream.of("a", "a", "aa", "bb", "ccc")
            .collect(Collectors.toUnmodifiableList());
    }
}
