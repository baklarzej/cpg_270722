package com.for_comprehension.function.l1_optional;

import java.util.List;
import java.util.Optional;

import com.for_comprehension.function.User;

public class L2_ProcessingOptional {

    public static void main(String[] args) {
        Optional<List<String>> strings = UserService.getUserById(2)
                .map(u -> u.getItems())
                .filter(v -> false);

        System.out.println(strings.isPresent());
        //

        Optional<User> foo = UserService.getUserById(42)
                .flatMap(u -> UserService.getUserByName("foo"));

        UserService.getUserById(42)
                .ifPresentOrElse(
                        System.out::println,
                        () -> System.out.println("not found"));
    }
}
