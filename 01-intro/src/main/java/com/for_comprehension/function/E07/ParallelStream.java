package com.for_comprehension.function.E07;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.concurrent.CompletableFuture.supplyAsync;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

class ParallelStream {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        List<Integer> list = IntStream.range(0, 10).boxed().collect(toList());

        CompletableFuture<List<Integer>> listCompletableFuture = parallelAsync(list, i -> {
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName());
            return i + 1;
        }, executorService);
        listCompletableFuture.join();

        executorService.shutdown();

    }

    static <T, R> List<R> parallelSync(Collection<T> input, Function<T, R> task, ExecutorService executor) {
        return parallelAsync(input, task, executor).join();
    }

    static <T, R> CompletableFuture<List<R>> parallelAsync(
        Collection<T> input,
        Function<T, R> task,
        ExecutorService executor) {

        return input.stream()
            .map(value -> supplyAsync(() -> task.apply(value), executor))
            .collect(collectingAndThen(toList(), ParallelStream::reduceToList));
    }

    static <T> CompletableFuture<List<T>> reduceToList(List<CompletableFuture<T>> futures) {
        // https://shipilev.net/blog/2016/arrays-wisdom-ancients/
        CompletableFuture<T>[] completableFutures = futures.toArray(CompletableFuture[]::new);

        CompletableFuture<Void> cf = CompletableFuture.allOf(completableFutures);
        for (CompletableFuture<T> future : futures) {
            future.whenComplete((t, throwable) -> {
                if (throwable != null) {
                    cf.completeExceptionally(throwable);
                }
            });
        }

        return cf.thenApply(__ -> futures)
            .thenApply(futuresToList());
    }

    private static <T> Function<List<CompletableFuture<T>>, List<T>> futuresToList() {
        return f -> f.stream().map(CompletableFuture::join).collect(toList());
    }

}
