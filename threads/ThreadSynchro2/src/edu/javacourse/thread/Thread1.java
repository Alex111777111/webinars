package edu.javacourse.thread;

public class Thread1  extends Thread
{
    @Override
    public void run() {
        try {
            System.out.println("Thread 1 is started");
            Thread2 t2 = new Thread2();
            t2.start();
            t2.join();
            System.out.println("Thread 1 is done");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
