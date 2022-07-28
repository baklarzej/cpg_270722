package com.for_comprehension.function.l2_stream;

import java.util.Optional;
import java.util.stream.Stream;

public class InfiniteStream {

    public static void main(String[] args) {
        Optional<Integer> first = Stream.generate(() -> 42)
//            .sorted()
            .findFirst();

        System.out.println(first.orElseThrow());
    }

}
