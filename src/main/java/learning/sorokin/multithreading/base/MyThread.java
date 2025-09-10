package learning.sorokin.multithreading.base;

class MyThread extends Thread {
    private final int threadId;

    public MyThread(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i + ": from thread #" + threadId);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}