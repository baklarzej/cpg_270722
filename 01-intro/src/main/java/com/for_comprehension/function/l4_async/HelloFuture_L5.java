package com.for_comprehension.function.l4_async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

public class HelloFuture_L5 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService e = Executors.newFixedThreadPool(2);

        var cf1 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            }
            catch (InterruptedException ex) {
            }
            return 1;
        }, e);
        var cf2 = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(5000));
            }
            catch (InterruptedException ex) {
            }
            return 2;
        }, e);

        cf1
            .applyToEither(cf2, i -> i)
            .thenAccept(System.out::println);

        CompletableFuture.supplyAsync(() -> 42, e)
            .thenCompose(i -> cf2)                  // flatMap(i -> cf2)
            .thenApply(i -> i + 1)                  // map(i -> i + 1)
            .thenAccept(System.out::println);       // ifPresent(System.out::println)

        e.shutdown();
    }

    public static void oldFuture() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> result = executorService.submit(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
            }

            return 42;
        });

        System.out.println(result.isDone());

        System.out.println(result.get());

        System.out.println(result.isDone());
    }

}
