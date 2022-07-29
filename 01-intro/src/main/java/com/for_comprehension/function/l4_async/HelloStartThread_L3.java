package com.for_comprehension.function.l4_async;

public class HelloStartThread_L3 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> System.out.println("Hello from another thread!"));
        thread.start();
        thread.stop();
    }

    public static void startThreadOldSchoold() {
        HelloThread helloThread = new HelloThread();
        helloThread.start();
    }

    // old school
    public static class HelloThread extends Thread {

        @Override
        public void run() {
            System.out.println("Hello from another thread!");
        }

    }

}
