package learning.sorokin.multithreading.counter.synchronizedblock;

class SimpleCounter {
    private int counter;
    private final Object object = new Object();

    public SimpleCounter() {
        this.counter = 0;
    }

    public void increment() {
        synchronized (object) {
            this.counter++;
        }
    }

//    public void increment() {
//        synchronized (this) {
//            this.counter++;
//        }
//    }

//    public synchronized void increment() {
//            this.counter++;
//    }

    public int getCounter() {
        return counter;
    }
}
