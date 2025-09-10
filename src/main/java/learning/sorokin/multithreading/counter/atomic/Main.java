package learning.sorokin.multithreading.counter.atomic;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Thread> threadList = new ArrayList<>();
        SimpleCounter simpleCounter = new SimpleCounter();

        for (int i = 0; i < 5; i++) {
            Thread thread = new MyThread(simpleCounter, i);
            thread.start();
            threadList.add(thread);
        }
        System.out.println("Circle for completed");

        for (Thread thread : threadList) {
            thread.join();
        }

        System.out.println("Simple Counter == " + simpleCounter.getCounter());
    }
}
