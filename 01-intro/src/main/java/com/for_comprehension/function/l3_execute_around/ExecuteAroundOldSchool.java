package com.for_comprehension.function.l3_execute_around;

public class ExecuteAroundOldSchool {

    public static void main(String[] args) {

        System.out.println("Entering method");
        compute();
        System.out.println("Exiting method");

        new ComputeWithLogging().run();
    }

    public static class ComputeWithLogging extends LoggingTemplateMethod {
        @Override
        public void runInternal() {
            compute();
        }
    }


    public static abstract class LoggingTemplateMethod {

        public abstract void runInternal();

        public void run() {
            System.out.println("Entering method");
            runInternal();
            System.out.println("Exiting method");
        }

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
