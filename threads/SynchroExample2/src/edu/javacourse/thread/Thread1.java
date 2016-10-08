package edu.javacourse.thread;

public class Thread1 extends Thread
{
    private Manager manager;

    public Thread1(Manager manager) {
        this.manager = manager;
    }
    
    public void run() {
        manager.methodWait();
    }
}
