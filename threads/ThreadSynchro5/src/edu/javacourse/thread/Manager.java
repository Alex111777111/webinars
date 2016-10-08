package edu.javacourse.thread;

public class Manager
{
    public static final int COUNT = 3;

    private int value;
    private boolean busy = false;

    public synchronized int get() {
        if (!busy) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("GET:" + value);
        busy = false;
        notifyAll();
        return value;
    }

    public synchronized void put(int value) {
        if (busy) {
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        this.value = value;
        System.out.println("PUT:" + this.value);
        busy = true;
        notifyAll();
    }
}
