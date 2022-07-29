package com.for_comprehension.function.l4_async.thread_stop_demo;

public class ConcurrentHolderThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHolderThreadInterrupt concurrentHolder = new ConcurrentHolderThreadInterrupt();
        Thread t1 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(10);
                    concurrentHolder.modify();
                }
                catch (InterruptedException e) {
                    System.out.println("t1 interrupted");
                    break;
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    Thread.sleep(12);
                    concurrentHolder.modify();
                }
                catch (InterruptedException e) {
                    System.out.println("t2 interrupted");
                    break;
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        t1.interrupt();

        Thread.sleep(2000);
        t2.interrupt();
    }

    private volatile String foo = "foo";

    private volatile String bar = "bar";

    public synchronized void modify() {
        System.out.println(foo);
        System.out.println(bar);

        var old_foo = foo;
        var old_bar = bar;

        foo = "blee";
        bar = "asdhaskdsa";

        foo = old_foo;
        bar = old_bar;
    }

    @Override
    public String toString() {
        return "ConcurrentHolder{" +
            "foo='" + foo + '\'' +
            ", bar='" + bar + '\'' +
            '}';
    }

}
