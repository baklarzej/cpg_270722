package com.for_comprehension.function;

import java.util.Collection;

class HelloWorld {

    public static void main(String[] args) {
        var foo = 1;
        System.out.println((foo + 1));

        System.out.println(foo);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello!");
            }
        };

    }

}
