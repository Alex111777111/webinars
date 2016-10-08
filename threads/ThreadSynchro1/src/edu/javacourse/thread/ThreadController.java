package edu.javacourse.thread;

public class ThreadController 
{
    private volatile int coordinator = 1;

    public void setCoordinator(int coordinator) {
        this.coordinator = coordinator;
    }
    
    public synchronized void executeThread1() {
        System.out.println("Thread 1 is started:" + coordinator);
        while(coordinator != 1) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Thread 1 is executed:" + coordinator);
        notifyAll();
    }

    public synchronized void executeThread2() {
        System.out.println("Thread 2 is started:" + coordinator);
        while(coordinator != 2) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Thread 2 is executed:" + coordinator);
        notifyAll();
    }

    public synchronized void executeThread3() {
        System.out.println("Thread 3 is started:" + coordinator);
        while(coordinator != 3) {
            try {
                wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Thread 3 is executed:" + coordinator);
    }
}
