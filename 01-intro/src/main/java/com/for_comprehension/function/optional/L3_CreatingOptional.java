package com.for_comprehension.function.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.for_comprehension.function.User;

public class L3_CreatingOptional {

    private static final Map<Integer, String> strings = new HashMap<>();

    public static void main(String[] args) {

    }

    public static Optional<String> getById(int id) {
        return Optional.ofNullable(strings.get(id));
    }
}
