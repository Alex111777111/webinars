package edu.javacourse.thread;

public class Thread1 implements Runnable 
{
    private ThreadController threadController;

    public Thread1(ThreadController threadController) {
        this.threadController = threadController;
    }
    
    @Override
    public void run() {
        threadController.executeThread1();
        threadController.setCoordinator(2);
    }

}
