package edu.javacourse.thread;

public class Consumer extends Thread
{
    private Manager manager;

    public Consumer(Manager manager) {
        this.manager = manager;
    }
    
    public void run() {
        for(int i=0; i<Manager.COUNT; i++) {
            manager.get();
        }
    }
}
