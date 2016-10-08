package edu.javacourse.thread;

public class ThreadSynchExample
{
    public static void main(String[] args) {
        Manager m = new Manager();
        Producer p = new Producer(m);
        Consumer c = new Consumer(m);
        
        p.start();
        c.start();
    }
    
}
