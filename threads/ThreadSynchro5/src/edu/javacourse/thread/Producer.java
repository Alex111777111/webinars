package edu.javacourse.thread;

public class Producer extends Thread
{
    private Manager manager;

    
    public Producer(Manager manager) {
        this.manager = manager;
    }
    
    
    
    public void run() {
        for(int i=0; i<Manager.COUNT; i++) {
            manager.put(i);
        }
    }
}
