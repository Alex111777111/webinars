package edu.javacourse.thread;

public class Resource
{
    public static final int COUNT = 5;

    private int value;
    private boolean busy = false;

    public synchronized void put(int value) {
        if (busy) {
            try {
                wait();
                Thread.sleep((int)(Math.random() * 1000));
            } catch (Exception e) {
            }
        }
        this.value = value;
        busy = true;
        System.out.println("PUT:" + value);
        notifyAll();
    }

    public synchronized int get() {
        if(!busy) {
            try {
                wait();
                Thread.sleep((int)(Math.random() * 1000));
            } catch (Exception e) {
            }
        }
        System.out.println("GET:" + value);
        busy = false;
        notifyAll();
        return value;
    }

}
