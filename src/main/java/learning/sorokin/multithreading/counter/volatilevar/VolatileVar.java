package learning.sorokin.multithreading.counter.volatilevar;

class VolatileVar {
    private static volatile boolean flag = true;

    public static void main(String[] args) throws InterruptedException {
        Thread worker = new Thread(() -> {
            System.out.println("Worker #" + Thread.currentThread().getName() + " started");
            while (flag) {
                int x = 0;
                for (int i = 0; i < 10000; i++) {
                    x++;
                }
            }
            System.out.println("Worker #" + Thread.currentThread().getName() + " ended");
        });

        worker.start();

        Thread.sleep(2000);

        System.out.println("Main request worker " + worker.getName() + " to stop");
        flag = false;

        worker.join();
        System.out.println("Main finished");
    }
}
