package edu.javacourse.thread;

public class SynchroExample
{
    public static void main(String[] args) throws Exception {
        Manager m = new Manager();
        for(int i=0; i<5; i++) {
            Thread1 t = new Thread1(m);
            t.start();
        }
        Thread.sleep(2000);
        m.startForWaiting();
    }
}
