package com.for_comprehension.function.l4_async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class HelloCombiningCompletableFuture_L7 {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService e = Executors.newFixedThreadPool(2);

        CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> 1, e);
        CompletableFuture<Integer> cf2 = CompletableFuture.supplyAsync(() -> 2, e);

        cf1.thenCombine(cf2, Integer::sum)
            .thenAccept(System.out::println)
            .join();


        // ----------------

        CompletableFuture<Integer> cf3 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            return 1;
        }, e);

        Thread.sleep(1000);

        // *Async
        cf3.thenRunAsync(() -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ex) {
            }
            System.out.println(Thread.currentThread().getName());
            System.out.println("foo");
        }).join();




    }

}
