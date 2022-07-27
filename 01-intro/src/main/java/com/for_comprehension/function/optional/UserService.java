package com.for_comprehension.function.optional;

import java.util.Optional;

import com.for_comprehension.function.User;

public class UserService {

    public static Optional<User> getUserById(int id) {
        User usr = new User();
        usr.addItem("apple");
        return Optional.of(usr);
    }

    public static Optional<User> getUserByName(String name) {
        User usr = new User();
        usr.addItem("orange");
        return Optional.of(usr);
    }
}
