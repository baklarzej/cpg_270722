package com.for_comprehension.function.l3_execute_around;

public class ExecuteAroundFunctional {

    public static void main(String[] args) {
        runWithLogging(ExecuteAroundFunctional::compute);
    }

    public static void runWithLogging(Runnable runnable) {
        System.out.println("Entering method");
        runnable.run();
        System.out.println("Exiting method");
    }

    public static void compute() {
        System.out.println("calculating...");
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
        }
        System.out.println("finished");
    }

}
