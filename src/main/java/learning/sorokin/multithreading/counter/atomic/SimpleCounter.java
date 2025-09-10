package learning.sorokin.multithreading.counter.atomic;

import java.util.concurrent.atomic.AtomicInteger;

class SimpleCounter {
    private final AtomicInteger counter;

    public SimpleCounter() {
        this.counter = new AtomicInteger(0);
    }

    public void increment() {
        this.counter.incrementAndGet();
    }

    public int getCounter() {
        return counter.get();
    }
}
