package com.for_comprehension.function.l4_async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloCFAnyOf_L9 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        var cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return 1;
        }, executorService);
        var cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            throw new NullPointerException();
        }, executorService);

        CompletableFuture<Object> voidCompletableFuture = CompletableFuture.anyOf(cf1, cf2);
        System.out.println(voidCompletableFuture.join());

        executorService.shutdown();
    }

}
