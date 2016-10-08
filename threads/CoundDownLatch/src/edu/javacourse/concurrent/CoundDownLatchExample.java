package edu.javacourse.concurrent;

import java.util.concurrent.CountDownLatch;

public class CoundDownLatchExample
{
    public static void main(String[] args) throws InterruptedException {
        final int N = 5;

        CountDownLatch startSignal = new CountDownLatch(1);
        CountDownLatch doneSignal = new CountDownLatch(N);

        for (int i = 0; i < N; ++i) {
            new Thread(new Worker(startSignal, doneSignal)).start();
        }

        doSomethingElse(1);            // don't let run yet
        startSignal.countDown();      // let all threads proceed
        doneSignal.await();           // wait for all to finish
        doSomethingElse(2);
    }

    private static void doSomethingElse(int phase) {
        try {
            Thread.sleep(2000);
            System.out.println("doSomethingElse is DONE: " + phase);
        } catch (Exception e) {

        }
    }

}

class Worker implements Runnable
{
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    Worker(CountDownLatch startSignal, CountDownLatch doneSignal) {
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void run() {
        try {
            System.out.println("Thread is waiting for start");
            startSignal.await();
            doWork();
            doneSignal.countDown();
        } catch (InterruptedException ex) {
        } // return;
    }

    void doWork() {
        System.out.println("Thread is done");
    }
}
