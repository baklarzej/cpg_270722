package com.for_comprehension.function.l4_async;

public class HelloDaemonThread_L1 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000000000);
                System.out.println("foo");
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

}
