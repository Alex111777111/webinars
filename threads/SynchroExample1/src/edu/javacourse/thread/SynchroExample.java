package edu.javacourse.thread;

public class SynchroExample
{
    public static void main(String[] args) {
       Resource r = new Resource();
       
       Producer p = new Producer(r);
       Consumer c = new Consumer(r);
       
       c.start();
       p.start();
    }
}
