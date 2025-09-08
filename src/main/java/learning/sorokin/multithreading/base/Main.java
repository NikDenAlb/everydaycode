package learning.sorokin.multithreading.base;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MyThread thread1 = new MyThread(1);
        MyThread thread2 = new MyThread(2);
        thread1.start();
        thread2.start();

        Thread.sleep(5000);
        System.out.println("---Waited 5000---");

        thread1.run();
        thread2.run();

        System.out.println("---5Threads:---");

        for (int i = 0; i < 5; i++) {
            MyThread thread = new MyThread(i);
            thread.start();
        }
    }
}