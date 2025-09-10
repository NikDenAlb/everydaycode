package learning.sorokin.multithreading.base;

class MyRunnable implements Runnable {
    private final int threadId;

    public MyRunnable(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        if (threadId == 3) {
            throw new RuntimeException();
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ": from thread with runnable #" + threadId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}