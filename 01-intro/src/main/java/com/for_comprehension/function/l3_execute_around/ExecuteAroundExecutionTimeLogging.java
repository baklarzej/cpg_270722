package com.for_comprehension.function.l3_execute_around;

import java.util.concurrent.ThreadLocalRandom;

public class ExecuteAroundExecutionTimeLogging {

    public static void main(String[] args) {
        int result = timed(() -> compute());
        System.out.println(result);
    }

    public static int compute() {
        System.out.println("calculating...");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        System.out.println("finished");
        return ThreadLocalRandom.current().nextInt();
    }

}
