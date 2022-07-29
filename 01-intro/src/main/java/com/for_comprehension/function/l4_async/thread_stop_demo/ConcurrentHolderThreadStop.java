package com.for_comprehension.function.l4_async.thread_stop_demo;

public class ConcurrentHolderThreadStop {

    public static void main(String[] args) throws InterruptedException {
        ConcurrentHolderThreadStop concurrentHolder = new ConcurrentHolderThreadStop();
        Thread t1 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    concurrentHolder.modify();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    concurrentHolder.modify();
                }
                catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        t1.start();
        t2.start();

        Thread.sleep(1000);
        t1.stop();

        Thread.sleep(2000);
        t2.stop();
    }

    private volatile String foo = "foo";
    private volatile String bar = "bar";

    public synchronized void modify() {
        System.out.println(foo);
        System.out.println(bar);

        var old_foo = foo;
        var old_bar = bar;

        foo = "blee";
        try {
            Thread.sleep(500);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        bar = "asdhaskdsa";

        try {
            Thread.sleep(10);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

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
