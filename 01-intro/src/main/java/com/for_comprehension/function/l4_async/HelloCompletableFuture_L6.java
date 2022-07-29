package com.for_comprehension.function.l4_async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloCompletableFuture_L6 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService e = Executors.newFixedThreadPool(2);

        var cf1 = CompletableFuture.supplyAsync(() -> {
            throw new NullPointerException();
        }, e);

        System.out.println(cf1.exceptionally(throwable -> 42).join());

        cf1.whenComplete((result, throwable) -> {
            if (throwable != null) {
                System.out.println(throwable.getMessage());
            }
            else {
                System.out.println(result);
            }
        });
    }

}
