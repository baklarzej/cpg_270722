package com.for_comprehension.function.l4_async;

public class HelloInterrupt_L4 {

    public static void main(String[] args) throws InterruptedException {

        Thread hello = new Thread(() -> {

            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(1000);
                }
                catch (InterruptedException e) {
                    break;
                }
                System.out.println("Hello!");
            }
        });

        hello.start();
        Thread.sleep(5000);
        System.out.println("Interrupting!");
        hello.interrupt();
    }

}
