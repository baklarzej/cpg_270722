package com.for_comprehension.function.l0_lambda;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

public class SupplierToCallable {

    public static void main(String[] args) {
        Supplier<Integer> supplier = () -> 42;

        // 1
        Callable<Integer> callable1 = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return 42;
            }
        };

        // 2
        Callable<Integer> callable2 = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return supplier.get();
            }
        };

        // 3
        Callable<Integer> callable3 = () -> supplier.get();

        // 4
        Callable<Integer> callable4 = supplier::get;

        // 5
        Function<Supplier<Integer>, Callable<Integer>> f = s -> s::get;
    }

}
