package learning.sorokin.multithreading.base;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);

        System.out.println("---2Threads start()---");
        thread1.start();
        thread2.start();

        Thread.sleep(5000);

        System.out.println("---2Threads run()---");
        thread1.run();
        thread2.run();

        System.out.println("---5Threads:---");

        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(i);
            thread.start();
        }

        Thread.sleep(5000);

        System.out.println("---5Runnables with broken id == 3:---");
        for (int i = 0; i < 5; i++) {
            Runnable runnable = new MyRunnable(i);
            new Thread(runnable).start();
        }
    }
}