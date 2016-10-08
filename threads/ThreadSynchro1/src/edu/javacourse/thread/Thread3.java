package edu.javacourse.thread;

public class Thread3 implements Runnable 
{
    private ThreadController threadController;

    public Thread3(ThreadController threadController) {
        this.threadController = threadController;
    }
    
    @Override
    public void run() {
        threadController.executeThread3();
    }

}
