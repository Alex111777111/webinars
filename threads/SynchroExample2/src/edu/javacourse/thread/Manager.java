package edu.javacourse.thread;

public class Manager
{
    public synchronized void methodWait() {
        System.out.println("Thread is waiting:" + Thread.currentThread().getId());
        try {
            wait();
        } catch (InterruptedException ex) {
        }
        System.out.println("Thread is done:" + Thread.currentThread().getId());
    }
    
    public synchronized void startForWaiting() {
        System.out.println("Start all threads");
        notifyAll();
    }
}
