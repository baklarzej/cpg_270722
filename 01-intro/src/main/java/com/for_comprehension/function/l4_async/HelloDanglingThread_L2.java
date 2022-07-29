package com.for_comprehension.function.l4_async;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HelloDanglingThread_L2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        executorService.submit(() -> {});

//        executorService.shutdown();
    }

}
