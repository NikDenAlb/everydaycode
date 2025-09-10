package learning.sorokin.multithreading.counter.race;

class SimpleCounter {
    private int counter;

    public SimpleCounter() {
        this.counter = 0;
    }

    public void increment() {
        this.counter++;
    }

    public int getCounter() {
        return counter;
    }
}
