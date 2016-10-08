package edu.javacourse.thread;

public class Thread2 extends Thread
{
    @Override
    public void run() {
        try {
            System.out.println("Thread 2 is started");
            Thread.sleep(2000);
            System.out.println("Thread 2 is done");
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }

}
