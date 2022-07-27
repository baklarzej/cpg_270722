package com.for_comprehension.function;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private final List<String> items = new ArrayList<>();

    public List<String> getItems() {
        return items;
    }

    public void addItem(String item) {
        int foo = 42;
        System.out.println("foo = " + foo);

        Objects.requireNonNull(item);
        items.add(item);
    }

    @Override
    public String toString() {
        return "User{" + "items=" + items + '}';
    }
}
