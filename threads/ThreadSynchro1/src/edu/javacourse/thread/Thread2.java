package edu.javacourse.thread;

public class Thread2 implements Runnable 
{
    private ThreadController threadController;

    public Thread2(ThreadController threadController) {
        this.threadController = threadController;
    }
    
    @Override
    public void run() {
        threadController.executeThread2();
        threadController.setCoordinator(3);
    }

}
