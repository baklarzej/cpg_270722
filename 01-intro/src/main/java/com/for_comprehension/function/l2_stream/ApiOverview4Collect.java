package com.for_comprehension.function.l2_stream;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toCollection;

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
    }
}
