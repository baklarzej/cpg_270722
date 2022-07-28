package com.for_comprehension.function.l2_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollectors {

    public static void main(String[] args) {
        List<Optional<Integer>> strings = Arrays.asList(Optional.of(1), Optional.of(1));

        String collect = strings.stream()
            .collect(joining());

        System.out.println(collect);
    }

    private static JoiningCollector<Optional<Integer>> joining() {
        return joining(",");
    }

    private static JoiningCollector<Optional<Integer>> joining(String delimiter) {
        return new JoiningCollector<>(delimiter);
    }

    public static class JoiningCollector<T> implements Collector<T, StringBuilder, String> {

        private final String delimiter;

        public JoiningCollector(String delimiter) {
            this.delimiter = delimiter;
        }

        public JoiningCollector() {
            this.delimiter = "";
        }

        @Override
        public Supplier<StringBuilder> supplier() {
            return StringBuilder::new;
        }

        @Override
        public BiConsumer<StringBuilder, T> accumulator() {
            return (stringBuilder, obj) -> {
                if (stringBuilder.toString().isEmpty()) {
                    stringBuilder.append(obj);
                } else {
                    stringBuilder.append(delimiter).append(obj);
                }
            };
        }

        @Override
        public BinaryOperator<StringBuilder> combiner() {
            return StringBuilder::append;
        }

        @Override
        public Function<StringBuilder, String> finisher() {
            return StringBuilder::toString;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of();
        }

    }


}
