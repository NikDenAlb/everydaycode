package learning.sorokin.multithreading.counter.synchronizedblock;

class MyThread extends Thread {
    private final SimpleCounter simpleCounter;

    private final int threadNumber;

    public MyThread(SimpleCounter simpleCounter, int threadNumber) {
        this.simpleCounter = simpleCounter;
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        System.out.println("thread #" + threadNumber + " is running");
        for (int i = 0; i < 5; i++) {
            simpleCounter.increment();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("thread #" + threadNumber + " is done");
    }
}
