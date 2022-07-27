package com.for_comprehension.function.optional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class L1_UnpackagingOptional {

    public static void main(String[] args) {
        UserService.getUserById(2)
                .map(u -> u.getItems())
                .ifPresent(System.out::println);

        List<String> r0 = UserService.getUserById(2)
                .map(u -> u.getItems())
//                .get()
                .orElseThrow(); // only if you know what you're doing

        List<String> r1 = UserService.getUserById(2)
                .map(u -> u.getItems())
                .orElse(Collections.emptyList());

        List<String> r2 = UserService.getUserById(2)
                .map(u -> u.getItems())
                .orElseGet(() -> Collections.emptyList());

        UserService.getUserById(2)
                .map(u -> u.getItems())
                .ifPresent(items -> System.out.println(items));

        Optional<List<String>> r3 = UserService.getUserById(2)
                .or(() -> UserService.getUserByName("Adam"))
                .map(u -> u.getItems());

        UserService.getUserById(2)
                .map(u -> u.getItems())
                .orElseThrow(() -> new IllegalStateException("asdhas"));








        /*
        if ( user.isPresent() ) {
            User u = user.get();
            List<String> items = u.getItems();
            if ( items != null ) {
                System.out.println(items);
            }
        }
        */
    }
}
