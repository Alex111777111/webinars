package edu.javacourse.thread;

public class ThreadSynchExample 
{
    public static void main(String[] args) throws InterruptedException {
        ThreadController tc = new ThreadController();
        Thread1 t1 = new Thread1(tc);
        Thread2 t2 = new Thread2(tc);
        Thread3 t3 = new Thread3(tc);
        
        new Thread(t3).start();
        Thread.sleep(1000);
        new Thread(t2).start();
        Thread.sleep(2000);
        new Thread(t1).start();
    }

}
